package com.wellsfargo.batch5.sbwdd.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterLibraryMemberModel {
	@NotNull(message = "User name is mandatory")
	@NotBlank(message = "User name is mandatory")
	@Size(min = 8, max = 20, message = "User name must be of 8 to 15 chars in length")
	private String userName;

	@NotNull(message = "Password is mandatory")
	@NotBlank(message = "Password is mandatory")
	@Size(min = 8, max = 15, message = "Password must between 8 and 15 characters")
	private String password;

	@NotNull(message = "User name is mandatory")
	@NotBlank(message = "User name is mandatory")
	@Size(min = 8, max = 20, message = "Confirm password must be of 8 to 15 chars in length")
	private String confirmPassword;

	@NotNull(message = "First name is mandatory")
	@NotBlank(message = "First name is mandatory")
	@Size(min = 8, max = 20, message = "First name must be of 8 to 15 chars in length")
	private String firstName;

	@NotNull(message = "Last Name is mandatory")
	@NotBlank(message = "Last Name is mandatory")
	@Size(min = 8, max = 20, message = "Last Name must be of 8 to 15 chars in length")
	private String lastName;

	@NotNull(message="Mobile Number is mandate")
	@Pattern(regexp = "[1-9][0-9]{9}",message="Mobile Number should be of 10 digits.")
	private String mobileNumber;
	
	@NotNull(message="Address line1 is mandatory")
	@NotBlank(message="Address line1 is mandatory")	
	private String addressLine1;
	
	@NotNull(message="Address line2 is mandatory")
	@NotBlank(message="Address line2 is mandatory")	
	private String addressLine2;
	
	@NotNull(message="City is mandatory")
	@NotBlank(message="City is mandatory")	
	private String city;

	public RegisterLibraryMemberModel() {

	}

	public RegisterLibraryMemberModel(String userName, String password, String confimrPassword, String firstName,
			String lastName, String mobileNumber, String addressLine1, String addressLine2, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confimrPassword;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
