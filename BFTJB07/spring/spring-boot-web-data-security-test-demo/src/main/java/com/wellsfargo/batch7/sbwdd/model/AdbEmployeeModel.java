package com.wellsfargo.batch7.sbwdd.model;

public class AdbEmployeeModel {
	private Integer userId;
	private String userName;
	private String name;
	private Double basic;
	

	public AdbEmployeeModel() {
		
	}
	
	public AdbEmployeeModel(Integer userId, String name, Double basic, String userName) {
		super();
		this.userId = userId;
		this.name = name;
		this.basic = basic;
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
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
