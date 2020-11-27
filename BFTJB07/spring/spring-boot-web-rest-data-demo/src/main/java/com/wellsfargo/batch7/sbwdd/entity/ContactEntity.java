package com.wellsfargo.batch7.sbwdd.entity;

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
public class ContactEntity implements Comparable<ContactEntity>{

	@Id
	@Column(name="cid")
	private Long contactId;
	
	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastNAme;
	
	@Embedded
	private ContactDetailsEntity contactDetails;
	
	@ManyToOne
	@JoinColumn(name="gid")
	private AddressGroupEntity adbGroup;

	public ContactEntity() {
		
	}
	
	public ContactEntity(Long contactId, String firstName, String lastNAme, ContactDetailsEntity contactDetails,
			AddressGroupEntity adbGroup) {
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

	public ContactDetailsEntity getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetailsEntity contactDetails) {
		this.contactDetails = contactDetails;
	}

	public AddressGroupEntity getAdbGroup() {
		return adbGroup;
	}

	public void setAdbGroup(AddressGroupEntity adbGroup) {
		this.adbGroup = adbGroup;
	}

	@Override
	public int compareTo(ContactEntity o) {
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
