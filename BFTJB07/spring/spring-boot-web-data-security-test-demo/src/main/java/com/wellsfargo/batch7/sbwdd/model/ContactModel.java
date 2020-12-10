package com.wellsfargo.batch7.sbwdd.model;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContactModel implements Comparable<ContactModel>{

	@NotNull(message="Contact Id is mandate")
	@Min(value=1,message="Contact Id can not be negative")
	private Long contactId;
	
	@NotNull(message="First Name is mandate")
	@NotBlank(message="First Name is mandate")
	private String firstName;
	
	@NotNull(message="Last Name is mandate")
	@NotBlank(message="Last Name is mandate")
	private String lastName;
	
	private ContactDetailsModel contactDetails;
	
	private AddressGroupModel adbGroup;

	public ContactModel() {
		
	}
	
	public ContactModel(Long contactId, String firstName, String lastNAme, ContactDetailsModel contactDetails,
			AddressGroupModel adbGroup) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastNAme;
		this.contactDetails = contactDetails;
		this.adbGroup = adbGroup;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastName;
	}

	public void setLastNAme(String lastNAme) {
		this.lastName = lastNAme;
	}

	public ContactDetailsModel getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetailsModel contactDetails) {
		this.contactDetails = contactDetails;
	}

	public AddressGroupModel getAdbGroup() {
		return adbGroup;
	}

	public void setAdbGroup(AddressGroupModel adbGroup) {
		this.adbGroup = adbGroup;
	}

	@Override
	public int compareTo(ContactModel o) {
		return this.contactId.compareTo(o.contactId);
	}
	
	@Override
	public int hashCode() {	
		return Objects.hashCode(this.contactId);
	}
	
	@Override
	public boolean equals(Object obj) {	
		return Objects.equals(this, obj);
	}
}
