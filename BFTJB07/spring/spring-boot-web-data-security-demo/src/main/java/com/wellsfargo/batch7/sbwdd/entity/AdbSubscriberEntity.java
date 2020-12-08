package com.wellsfargo.batch7.sbwdd.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="adb_subs")
public class AdbSubscriberEntity extends AdbUserEntity{

	@Column(name="fnm")
	private String first_name;
	
	@Column(name="lnm")
	private String last_name;
	
	@Embedded
	private ContactDetailsEntity subscriberContactDetails;
	
	public AdbSubscriberEntity() {
		
	}

	public AdbSubscriberEntity(Integer userId, String userName, String password, String role,String first_name, String last_name) {
		super(userId, userName, password, role);
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public ContactDetailsEntity getSubscriberContactDetails() {
		return subscriberContactDetails;
	}

	public void setSubscriberContactDetails(ContactDetailsEntity subscriberContactDetails) {
		this.subscriberContactDetails = subscriberContactDetails;
	}

	@Override
	public String toString() {
		return "AdbSubscriber [first_name=" + first_name + ", last_name=" + last_name + ", subscriberContactDetails="
				+ subscriberContactDetails + "]";
	}
	
	
}
