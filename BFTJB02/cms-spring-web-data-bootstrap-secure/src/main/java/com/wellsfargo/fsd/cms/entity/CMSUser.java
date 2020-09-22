package com.wellsfargo.fsd.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cmsusers")
public class CMSUser {

	@Id
	@GeneratedValue
	private Integer userId;
	@Column(name="unm",unique = true)
	private String userName;
	@Transient
	private String password;
	@Column(name="pwd")
	private String encodedPassword;
	@Column(name="role")
	private String role;
	
	public CMSUser() {
		
	}

	public CMSUser(Integer userId, String userName, String password, String encodedPassword, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.encodedPassword = encodedPassword;
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

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

		
}
