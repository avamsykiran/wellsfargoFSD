package com.wellsfargo.batch5.sbwdd.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="members1")
public class LibraryMember extends LibraryUser{
	
	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastName;
	
	@Embedded
	private ContactDetails address;
	
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

	public ContactDetails getAddress() {
		return address;
	}

	public void setAddress(ContactDetails address) {
		this.address = address;
	}
	
	

}
