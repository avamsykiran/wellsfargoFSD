package com.wellsfargo.batch7.sbwdd.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContactDetailsModel {

	@NotNull(message="Mobile number is mandate")
	@NotBlank(message="Mobile number is mandate")
	@Pattern(regexp = "[1-9][0-9]{9}",message = "Mobile number must be exactly ten digits")
	private String mobileNumber;
	
	@NotNull(message="Mail Id is mandate")
	@NotBlank(message="Mail Id is mandate")
	@Email(message = "Email Id is not valied")
	private String emailId;
	
	@NotNull(message="Address Line1 number is mandate")
	@NotBlank(message="Address Line1 number is mandate")
	private String addressLine1;
	
	private String addressLine2;
	
	@NotNull(message="city number is mandate")
	@NotBlank(message="Address Line1 number is mandate")
	private String city;
	
	@NotNull(message="state number is mandate")
	@NotBlank(message="state number is mandate")
	private String state;
	
	public ContactDetailsModel() {
		
	}
	public ContactDetailsModel(String mobileNumber, String emailId, String addressLine1, String addressLine2, String city,
			String state) {
		super();
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ContactDetails [mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
