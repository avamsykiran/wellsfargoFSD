package com.wellsfargo.batch7.ab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.Contact;

public class ContactDaoImpl implements IContactDao {

	public static final String INS_QRY = "INSERT INTO contacts(cid,cname,grp,dob,mobile) VALUES(?,?,?,?,?)";
	public static final String UPD_QRY = "UPDATE contacts SET cname=?,grp=?,dob=?,mobile=? WHERE cid=?";
	public static final String DEL_QRY = "DELETE FROM contacts WHERE cid=?";
	public static final String SELECT_BY_ID_QRY = "SELECT cid,cname,grp,dob,mobile FROM contacts WHERE cid=?";
	public static final String SELECT_ALL_QRY = "SELECT cid,cname,grp,dob,mobile FROM contacts";

	Logger log = Logger.getLogger("dao");

	@Override
	public Contact add(Contact contact) throws AddressBookException {
		if (contact != null) {
			try (Connection con = ConnectionProvider.getConn(); PreparedStatement ps = con.prepareStatement(INS_QRY)) {

				ps.setInt(1, contact.getContactId());
				ps.setString(2, contact.getName());
				ps.setString(3, contact.getGroup());
				ps.setDate(4, Date.valueOf(contact.getDateOfBirth()));
				ps.setString(5, contact.getMobile());

				ps.executeUpdate();
			} catch (SQLException exp) {
				log.error(exp);
				throw new AddressBookException("Operation Failed Due To An Error!");
			}
		}
		return contact;
	}

	@Override
	public Contact save(Contact contact) throws AddressBookException {
		if (contact != null) {
			try (Connection con = ConnectionProvider.getConn(); PreparedStatement ps = con.prepareStatement(UPD_QRY)) {

				ps.setString(1, contact.getName());
				ps.setString(2, contact.getGroup());
				ps.setDate(3, Date.valueOf(contact.getDateOfBirth()));
				ps.setString(4, contact.getMobile());
				ps.setInt(5, contact.getContactId());

				ps.executeUpdate();
			} catch (SQLException exp) {
				log.error(exp);
				throw new AddressBookException("Operation Failed Due To An Error!");
			}
		}
		return contact;
	}

	@Override
	public void delete(int contactId) throws AddressBookException {
		try (Connection con = ConnectionProvider.getConn(); 
				PreparedStatement ps = con.prepareStatement(DEL_QRY)) {

			ps.setInt(1, contactId);
			ps.executeUpdate();
			
		} catch (SQLException exp) {
			log.error(exp);
			throw new AddressBookException("Operation Failed Due To An Error!");
		}
	}

	@Override
	public Contact getById(int contactId) throws AddressBookException {
		Contact contact=null;
		try (Connection con = ConnectionProvider.getConn(); 
				PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_QRY)) {

			ps.setInt(1, contactId);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				contact = new Contact();
				contact.setContactId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setGroup(rs.getString(3));
				contact.setDateOfBirth(rs.getDate(4).toLocalDate());
				contact.setMobile(rs.getString(5));
			}
		} catch (SQLException exp) {
			log.error(exp);
			throw new AddressBookException("Operation Failed Due To An Error!");
		}		
		return contact;
	}

	@Override
	public List<Contact> getAll() throws AddressBookException {
		List<Contact> contacts=new ArrayList<Contact>();
		try (Connection con = ConnectionProvider.getConn(); 
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_QRY)) {

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setContactId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setGroup(rs.getString(3));
				contact.setDateOfBirth(rs.getDate(4).toLocalDate());
				contact.setMobile(rs.getString(5));
				
				contacts.add(contact);
			}
		} catch (SQLException exp) {
			log.error(exp);
			throw new AddressBookException("Operation Failed Due To An Error!");
		}		
		return contacts;
	}

}
