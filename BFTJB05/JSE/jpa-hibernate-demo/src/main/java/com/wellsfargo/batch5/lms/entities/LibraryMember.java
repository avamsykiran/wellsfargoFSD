package com.wellsfargo.batch5.lms.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("mem")
@Table(name="members1")
public class LibraryMember extends LibraryUser{
	
	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastName;
	
	public LibraryMember() {
		
	}

	public LibraryMember(Integer libUserId, String userName, String password, String role,String firstName, String lastName) {
		super(libUserId, userName, password, role);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
