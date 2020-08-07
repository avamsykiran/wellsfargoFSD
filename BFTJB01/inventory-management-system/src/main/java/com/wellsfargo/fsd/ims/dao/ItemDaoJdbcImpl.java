package com.wellsfargo.fsd.ims.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				pst.setString(2, item.getTitle());
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
	public Item save(Item item) throws ImsException {
		if (item != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_ITEM_QRY)) {

				pst.setString(1, item.getTitle());
				pst.setDate(2, Date.valueOf(item.getPackageDate()));
				pst.setBoolean(3, item.getFragile());
				pst.setString(4, item.getUnit());
				pst.setDouble(5, item.getCostPrice());
				pst.setDouble(6, item.getSellingPrice());
				pst.setInt(7, item.getIcode());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new ImsException("Saving the item failed!");
			}
		}
		return item;
	}

	@Override
	public boolean deleteById(Integer icode) throws ImsException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_ITEM_QRY)) {

			pst.setInt(1, icode);

			int rowsCount = pst.executeUpdate();

			isDeleted = rowsCount > 0;

		} catch (SQLException exp) {
			throw new ImsException("Deleting the item failed!");
		}

		return isDeleted;
	}

	@Override
	public Item getById(Integer icode) throws ImsException {
		Item item = null;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ITEM_QRY_BY_ID)) {

			pst.setInt(1, icode);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				item = new Item();
				item.setIcode(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setPackageDate(rs.getDate(3).toLocalDate());
				item.setFragile(rs.getBoolean(4));
				item.setUnit(rs.getString(5));
				item.setCostPrice(rs.getDouble(6));
				item.setSellingPrice(rs.getDouble(7));
			}

		} catch (SQLException exp) {
			throw new ImsException("Retrival the item failed!");
		}

		return item;
	}

	@Override
	public List<Item> getAll() throws ImsException {
		List<Item> items = new ArrayList<>();

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ALL_ITEMS_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setIcode(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setPackageDate(rs.getDate(3).toLocalDate());
				item.setFragile(rs.getBoolean(4));
				item.setUnit(rs.getString(5));
				item.setCostPrice(rs.getDouble(6));
				item.setSellingPrice(rs.getDouble(7));
				
				items.add(item);
			}
			
			if(items.isEmpty()) {
				items=null;
			}
		} catch (SQLException exp) {
			throw new ImsException("Retrival the item failed!");
		}
		return items;
	}

}
