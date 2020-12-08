package com.wellsfargo.batch7.sbwdd.model;

public class AdbSubscriberModel {

	private Integer userId;
	private String userName;
	private String firstName;
	private String lastName;
	
	private ContactDetailsModel subscriberContactDetails;
	
	public AdbSubscriberModel() {
		
	}

	public AdbSubscriberModel(Integer userId, String userName, String first_name, String last_name,
			ContactDetailsModel subscriberContactDetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = first_name;
		this.lastName = last_name;
		this.subscriberContactDetails = subscriberContactDetails;
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

	public ContactDetailsModel getSubscriberContactDetails() {
		return subscriberContactDetails;
	}

	public void setSubscriberContactDetails(ContactDetailsModel subscriberContactDetails) {
		this.subscriberContactDetails = subscriberContactDetails;
	}

	@Override
	public String toString() {
		return "AdbSubscriber [first_name=" + firstName + ", last_name=" + lastName + ", subscriberContactDetails="
				+ subscriberContactDetails + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
