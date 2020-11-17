package com.wellsfargo.batch5.lms.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity

/*@Table(name="lib_users")
 * @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
 * @DiscriminatorColumn(name="userType",discriminatorType=DiscriminatorType.STRING)
 * @DiscriminatorValue("lu")
 */

@Table(name="lib_users1")
@Inheritance(strategy=InheritanceType.JOINED)
public class LibraryUser {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer libUserId;
	
	@Column(name="unm",nullable=true,unique=true)
	private String userName;
	
	@Column(name="pwd",nullable=true)
	private String password;
	
	@Column(name="role",nullable=true)
	private String role;
	
	public LibraryUser() {
		
	}

	public LibraryUser(Integer libUserId, String userName, String password,String role) {
		super();
		this.libUserId = libUserId;
		this.userName = userName;
		this.password = password;
		this.role=role;
	}

	public Integer getLibUserId() {
		return libUserId;
	}

	public void setLibUserId(Integer libUserId) {
		this.libUserId = libUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LibraryUser [libUserId=" + libUserId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
