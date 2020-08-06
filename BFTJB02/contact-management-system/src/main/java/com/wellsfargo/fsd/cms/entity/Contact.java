package com.wellsfargo.fsd.cms.entity;

import java.time.LocalDate;

public class Contact {
	
	private Integer contactId;
	private String fullName;
	private LocalDate dateOfBirth;
	private String mobile;
	
	public Contact() {
		//left unimplemented.
	}

	public Contact(Integer contactId, String fullName, LocalDate dateOfBirth, String mobile) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", mobile=" + mobile + "]";
	}
	
	
}
