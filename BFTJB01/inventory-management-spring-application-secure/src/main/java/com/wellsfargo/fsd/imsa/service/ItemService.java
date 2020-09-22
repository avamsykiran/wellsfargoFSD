package com.wellsfargo.fsd.imsa.service;

import java.util.List;

import com.wellsfargo.fsd.imsa.entity.Item;
import com.wellsfargo.fsd.imsa.exception.ImsException;

public interface ItemService {

	Item add(Item item) throws ImsException;

	Item save(Item item) throws ImsException;

	boolean deleteItem(int icode) throws ImsException;

	Item getItemById(int icode) throws ImsException;

	List<Item> getAllItems() throws ImsException;
}
