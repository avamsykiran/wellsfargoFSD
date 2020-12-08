package com.wellsfargo.batch7.sbwdd.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="adb_subs")
public class AdbSubscriberEntity extends AdbUserEntity{

	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastName;
	
	@Embedded
	private ContactDetailsEntity subscriberContactDetails;
	
	public AdbSubscriberEntity() {
		
	}

	public AdbSubscriberEntity(Integer userId, String userName, String password, String role,String first_name, String last_name) {
		super(userId, userName, password, role);
		this.firstName = first_name;
		this.lastName = last_name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public ContactDetailsEntity getSubscriberContactDetails() {
		return subscriberContactDetails;
	}

	public void setSubscriberContactDetails(ContactDetailsEntity subscriberContactDetails) {
		this.subscriberContactDetails = subscriberContactDetails;
	}

	@Override
	public String toString() {
		return "AdbSubscriber [first_name=" + firstName + ", last_name=" + lastName + ", subscriberContactDetails="
				+ subscriberContactDetails + "]";
	}
	
	
}
