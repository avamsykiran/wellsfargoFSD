package com.wellsfargo.batch5.sbwdd.model;

public class RegisterLibraryMemberModel {

	private String userName;
	private String password;
	private String confimrPassword;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	
	public RegisterLibraryMemberModel() {
		
	}
	
	public RegisterLibraryMemberModel(String userName, String password, String confimrPassword, String firstName,
			String lastName, String mobileNumber, String addressLine1, String addressLine2, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.confimrPassword = confimrPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfimrPassword() {
		return confimrPassword;
	}

	public void setConfimrPassword(String confimrPassword) {
		this.confimrPassword = confimrPassword;
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
