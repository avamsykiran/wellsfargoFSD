package com.wellsfargo.batch5.sbwdd.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactDetails {
	
	@Column(name="mno")
	private String mobileNumber;
	
	@Column(name="adl1")
	private String addressLine1;
	
	@Column(name="adl2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;

	public ContactDetails() {
		
	}
	public ContactDetails(String mobileNumber, String addressLine1, String addressLine2, String city) {
		super();
		this.mobileNumber = mobileNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
}
