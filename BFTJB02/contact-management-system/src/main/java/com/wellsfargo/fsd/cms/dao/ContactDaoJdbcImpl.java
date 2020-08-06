package com.wellsfargo.fsd.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import java.sql.PreparedStatement;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public class ContactDaoJdbcImpl implements ContactDao {

	public static final String INS_CONT_QRY=
			"INSERT INTO contacts(cid,cname,dob,mobile) VALUES(?,?,?,?)";
	public static final String UPD_CONT_QRY=		
			"UPDATE contacts set cname=?,dob=?,mobile=? WHERE cid=?";
	public static final String DEL_CONT_QRY=
			"DELETE FROM contacts WHERE cid=?";
	public static final String GET_CONT_BY_ID_QRY=
			"SELECT cid,cname,dob,mobile FROM contacts WHERE cid=?";
	public static final String GET_ALL_CONTS_QRY=
			"SELECT cid,cname,dob,mobile FROM contacts";
	
	@Override
	public Contact add(Contact contact) throws ContactException {
		
		if(contact!=null) {
			try(Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_CONT_QRY);
					){
				
				pst.setInt(1, contact.getContactId());
				pst.setString(2, contact.getFullName());
				pst.setDate(3, Date.valueOf(contact.getDateOfBirth()));
				pst.setString(4, contact.getMobile());
				
				pst.executeUpdate();
			}catch(SQLException exp) {
				throw new ContactException("Saving Contact failed!");
			}
		}
		
		return contact;
	}

	@Override
	public Contact save(Contact contact) throws ContactException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int contactId) throws ContactException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contact getById(int contactId) throws ContactException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAll() throws ContactException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
