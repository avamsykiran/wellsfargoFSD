package com.wellsfargo.fsd.ims.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.ims.dao.ItemDao;
import com.wellsfargo.fsd.ims.dao.ItemDaoJdbcImpl;
import com.wellsfargo.fsd.ims.entity.Item;
import com.wellsfargo.fsd.ims.exception.ImsException;

public class ItemServiceImpl implements ItemService {

	ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoJdbcImpl();
	}

	private boolean isIcodeValid(Integer icode) {
		return icode > 0;
	}

	private boolean isTitleValid(String title) {
		return title != null && (title.length() >= 3 || title.length() <= 20);
	}

	private boolean isFragileValid(Boolean fragile) {
		return fragile != null;
	}

	private boolean isPackageDateValid(LocalDate packageDate) {
		LocalDate today = LocalDate.now();
		return today.isAfter(packageDate) || today.isEqual(packageDate);
	}

	private boolean isUnitValid(String unit) {
		return unit != null;
	}

	private boolean isPriceValid(Double price) {
		return price >= 0;
	}

	private boolean isValidItem(Item item) throws ImsException {
		List<String> errMsg = new ArrayList<>();

		boolean isValid = true;

		if (!isIcodeValid(item.getIcode())) {
			isValid = false;
			errMsg.add("Icode can not be null or negative or zero");
		}

		if (!isTitleValid(item.getTitle())) {
			isValid = false;
			errMsg.add("Title can not be blank, title must be of 3 to 20 chars in length");
		}

		if (!isPackageDateValid(item.getPackageDate())) {
			isValid = false;
			errMsg.add("PackageDate can not be a future date");
		}

		if (!isUnitValid(item.getUnit())) {
			isValid = false;
			errMsg.add("Unit can not be null");
		}

		if (!isPriceValid(item.getCostPrice())) {
			isValid = false;
			errMsg.add("Cost price can not be zero or negative");
		}

		if (!isPriceValid(item.getSellingPrice())) {
			isValid = false;
			errMsg.add("selling price can not be zero or negative");
		}

		if (!isFragileValid(item.getFragile())) {
			isValid = false;
			errMsg.add("Fragility can not be null");
		}

		if (!isValid) {
			throw new ImsException(errMsg.toString());
		}

		return isValid;
	}

	@Override
	public Item validateAndAdd(Item item) throws ImsException {
		if(item!=null) {
			if(isValidItem(item)) {
				itemDao.add(item);
			}
		}
		return item;
	}

	@Override
	public Item validateAndSave(Item item) throws ImsException {
		if(item!=null) {
			if(isValidItem(item)) {
				itemDao.save(item);
			}
		}
		return item;
	}

	@Override
	public boolean deleteItem(int icode) throws ImsException {
		return itemDao.deleteById(icode);
	}

	@Override
	public Item getItemById(int icode) throws ImsException {
		return itemDao.getById(icode);
	}

	@Override
	public List<Item> getAllItems() throws ImsException {
		return itemDao.getAll();
	}

}
