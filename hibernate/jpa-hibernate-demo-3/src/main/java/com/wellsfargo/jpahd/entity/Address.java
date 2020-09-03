package com.wellsfargo.jpahd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{

	@Column(name="dno",nullable = false)
	private String doorNumber;
	@Column(name="street",nullable = false)
	private String street;
	@Column(name="city",nullable=false)
	private String city;
	
	public Address() {
		//left unimplemented
	}

	public Address(String doorNumber, String street, String city) {
		super();
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
