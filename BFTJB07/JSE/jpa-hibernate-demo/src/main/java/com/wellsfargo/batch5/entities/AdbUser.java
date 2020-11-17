package com.wellsfargo.batch5.entities;

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
/*@Table(name="all_users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("usr")
*/

@Table(name="adb_user_main")
@Inheritance(strategy=InheritanceType.JOINED)
public class AdbUser {

	@Id
	@Column(name="uid")
	@GeneratedValue
	private Integer userId;
	
	@Column(name="unm",nullable=false,unique=true)
	private String userName;
	
	@Column(name="pwd",nullable=false)
	private String password;
	
	@Column(name="role",nullable=false)
	private String role;

	public AdbUser() {
		
	}

	public AdbUser(Integer userId, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	
}
