package com.wellsfargo.fsd.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public class ContactDaoJdbcImpl implements ContactDao {

	public static final String INS_CONT_QRY = "INSERT INTO contacts(cid,cname,dob,mobile) VALUES(?,?,?,?)";
	public static final String UPD_CONT_QRY = "UPDATE contacts set cname=?,dob=?,mobile=? WHERE cid=?";
	public static final String DEL_CONT_QRY = "DELETE FROM contacts WHERE cid=?";
	public static final String GET_CONT_BY_ID_QRY = "SELECT cid,cname,dob,mobile FROM contacts WHERE cid=?";
	public static final String GET_ALL_CONTS_QRY = "SELECT cid,cname,dob,mobile FROM contacts";

	@Override
	public Contact add(Contact contact) throws ContactException {

		if (contact != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_CONT_QRY);) {

				pst.setInt(1, contact.getContactId());
				pst.setString(2, contact.getFullName());
				pst.setDate(3, Date.valueOf(contact.getDateOfBirth()));
				pst.setString(4, contact.getMobile());

				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new ContactException("Saving Contact failed!");
			}
		}

		return contact;
	}

	@Override
	public Contact save(Contact contact) throws ContactException {
		if (contact != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_CONT_QRY);) {

				pst.setString(1, contact.getFullName());
				pst.setDate(2, Date.valueOf(contact.getDateOfBirth()));
				pst.setString(3, contact.getMobile());
				pst.setInt(4, contact.getContactId());

				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new ContactException("Saving Contact failed!");
			}
		}

		return contact;
	}

	@Override
	public boolean deleteById(int contactId) throws ContactException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_CONT_QRY);) {

			pst.setInt(1, contactId);

			int rowsCount = pst.executeUpdate();

			isDeleted = rowsCount > 0;

		} catch (SQLException exp) {
			throw new ContactException("Deleting Contact failed!");
		}
		return isDeleted;
	}

	@Override
	public Contact getById(int contactId) throws ContactException {
		Contact contact = null;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_CONT_BY_ID_QRY);) {

			pst.setInt(1, contactId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				contact = new Contact();
				contact.setContactId(rs.getInt(1));
				contact.setFullName(rs.getString(2));
				contact.setDateOfBirth(rs.getDate(3).toLocalDate());
				contact.setMobile(rs.getString(4));
			}

		} catch (SQLException exp) {
			throw new ContactException("Feteching Contact failed!");
		}

		return contact;
	}

	@Override
	public List<Contact> getAll() throws ContactException {
		List<Contact> contacts = new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_CONTS_QRY);) {
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setContactId(rs.getInt(1));
				contact.setFullName(rs.getString(2));
				contact.setDateOfBirth(rs.getDate(3).toLocalDate());
				contact.setMobile(rs.getString(4));
				
				contacts.add(contact);
			}
			
			if(contacts.isEmpty()) {
				contacts=null;
			}

		} catch (SQLException exp) {
			throw new ContactException("Feteching Contact failed!");
		}
		
		return contacts;
	}

}