package com.wellsfargo.batch7.sbwdd.model;

public class AdbSubscriberModel {

	private Integer userId;
	private String userName;
	private String first_name;
	private String last_name;
	
	private ContactDetailsModel subscriberContactDetails;
	
	public AdbSubscriberModel() {
		
	}

	public AdbSubscriberModel(Integer userId, String userName, String first_name, String last_name,
			ContactDetailsModel subscriberContactDetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.first_name = first_name;
		this.last_name = last_name;
		this.subscriberContactDetails = subscriberContactDetails;
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

	public ContactDetailsModel getSubscriberContactDetails() {
		return subscriberContactDetails;
	}

	public void setSubscriberContactDetails(ContactDetailsModel subscriberContactDetails) {
		this.subscriberContactDetails = subscriberContactDetails;
	}

	@Override
	public String toString() {
		return "AdbSubscriber [first_name=" + first_name + ", last_name=" + last_name + ", subscriberContactDetails="
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
