package com.wellsfargo.batch7.ab.model;

import java.time.LocalDate;

public class Contact {

	private Integer contactId;
	private String name;
	private String group;
	private LocalDate dateOfBirth;
	private String mobile;

	public Contact() {

	}

	public Contact(Integer contactId, String name, String group, LocalDate dateOfBirth, String mobile) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.group = group;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

}
