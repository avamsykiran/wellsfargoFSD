package com.wellsfargo.fsd.ims.dao;

import java.util.List;

import com.wellsfargo.fsd.ims.entity.Item;
import com.wellsfargo.fsd.ims.exception.ImsException;

public interface ItemDao {

	Item add(Item item) throws ImsException;
	Item save(Item item);
	boolean deleteById(Integer icode);
	
	Item getById(Integer icode);
	List<Item> getAll();
	
}
