package com.wellsfargo.batch5.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact implements Comparable<Contact>{

	@Id
	@Column(name="cid")
	private Long contactId;
	
	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastNAme;
	
	@Embedded
	private ContactDetails contactDetails;
	
	@ManyToOne
	@JoinColumn(name="gid")
	private AddressGroup adbGroup;

	public Contact() {
		
	}
	
	public Contact(Long contactId, String firstName, String lastNAme, ContactDetails contactDetails,
			AddressGroup adbGroup) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastNAme = lastNAme;
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
		return lastNAme;
	}

	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public AddressGroup getAdbGroup() {
		return adbGroup;
	}

	public void setAdbGroup(AddressGroup adbGroup) {
		this.adbGroup = adbGroup;
	}

	@Override
	public int compareTo(Contact o) {
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
