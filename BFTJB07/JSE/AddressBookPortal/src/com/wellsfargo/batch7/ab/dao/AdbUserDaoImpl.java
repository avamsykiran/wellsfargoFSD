package com.wellsfargo.batch7.ab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.AdbUser;

public class AdbUserDaoImpl implements IAdbUserDao{

	private static String GET_USER_QRY=
			"SELECT * FROM adb_users WHERE user_name=?";
	private static String ADD_USER_QRY=
			"INSERT INTO adb_users VALUES(?,?,?)";
	
	Logger log = Logger.getLogger("userDao");
	
	@Override
	public AdbUser getUser(String userName) throws AddressBookException {
		AdbUser user=null;
		try(Connection con = ConnectionProvider.getConn();
				PreparedStatement pst = con.prepareStatement(GET_USER_QRY)){
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new AdbUser();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			log.error(e);
			throw new AddressBookException("User details could not be fetched");
		}
		return user;
	}

	@Override
	public AdbUser addUser(AdbUser user) throws AddressBookException {		
		try(Connection con = ConnectionProvider.getConn();
				PreparedStatement pst = con.prepareStatement(ADD_USER_QRY)){
			
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getRole());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e);
			throw new AddressBookException("User details could not be saved");
		}
		return user;
	}

}
