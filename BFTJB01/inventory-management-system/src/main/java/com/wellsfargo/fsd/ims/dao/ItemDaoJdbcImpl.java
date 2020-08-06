package com.wellsfargo.fsd.ims.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.wellsfargo.fsd.ims.entity.Item;
import com.wellsfargo.fsd.ims.exception.ImsException;

public class ItemDaoJdbcImpl implements ItemDao {

	public static final String INS_ITEM_QRY = "INSERT INTO items(icode,title,packageDate,fragile,unit,costPrice,sellingPrice) values(?,?,?,?,?,?,?)";
	public static final String UPD_ITEM_QRY = "UPDATE items SET title=?,packageDate=?,fragile=?,unit=?,costPrice=?,sellingPrice=? WHERE icode=?";
	public static final String DEL_ITEM_QRY = "DELETE FROM items WHERE icode=?";
	public static final String SEL_ITEM_QRY_BY_ID = "SELECT icode,title,packageDate,fragile,unit,costPrice,sellingPrice FROM items WHERE icode=?";
	public static final String SEL_ALL_ITEMS_QRY = "SELECT icode,title,packageDate,fragile,unit,costPrice,sellingPrice FROM items";

	@Override
	public Item add(Item item) throws ImsException {
		if (item != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_ITEM_QRY)) {

				pst.setInt(1, item.getIcode());
				pst.setString(2,item.getTitle());
				pst.setDate(3, Date.valueOf(item.getPackageDate()));
				pst.setBoolean(4, item.getFragile());
				pst.setString(5, item.getUnit());
				pst.setDouble(6, item.getCostPrice());
				pst.setDouble(7, item.getSellingPrice());
				
				pst.executeUpdate();
				
			} catch (SQLException exp) {
				throw new ImsException("Saving the item failed!");
			}
		}
		return item;
	}

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer icode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item getById(Integer icode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
