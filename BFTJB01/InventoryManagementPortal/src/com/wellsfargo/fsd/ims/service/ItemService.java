package com.wellsfargo.fsd.ims.service;

import java.util.List;

import com.wellsfargo.fsd.ims.entity.Item;
import com.wellsfargo.fsd.ims.exception.ImsException;

public interface ItemService {

	Item validateAndAdd(Item item) throws ImsException;

	Item validateAndSave(Item item) throws ImsException;

	boolean deleteItem(int icode) throws ImsException;

	Item getItemById(int icode) throws ImsException;

	List<Item> getAllItems() throws ImsException;
}
