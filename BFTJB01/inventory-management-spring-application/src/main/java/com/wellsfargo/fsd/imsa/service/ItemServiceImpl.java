package com.wellsfargo.fsd.imsa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.imsa.dao.ItemRepository;
import com.wellsfargo.fsd.imsa.entity.Item;
import com.wellsfargo.fsd.imsa.exception.ImsException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	@Override
	@Transactional
	public Item add(Item item) throws ImsException {
		if(item!=null) {
			if(itemRepo.existsById(item.getIcode())) {
				throw new ImsException("Item code already used!");
			}
			
			itemRepo.save(item);
		}
		return item;
	}

	@Override
	@Transactional
	public Item save(Item item) throws ImsException {
		if(item!=null) {
			if(!itemRepo.existsById(item.getIcode())) {
				throw new ImsException("Item Not Found");
			}
			
			itemRepo.save(item);
		}
		return item;
	}

	@Override
	@Transactional
	public boolean deleteItem(int icode) throws ImsException {
		if(!itemRepo.existsById(icode)) {
			throw new ImsException("Item Not Found");
		}
	
		itemRepo.deleteById(icode);
		return true;
	}

	@Override
	public Item getItemById(int icode) throws ImsException {
		return itemRepo.findById(icode).orElse(null);		
	}

	@Override
	public List<Item> getAllItems() throws ImsException {
		return itemRepo.findAll();
	}

}
