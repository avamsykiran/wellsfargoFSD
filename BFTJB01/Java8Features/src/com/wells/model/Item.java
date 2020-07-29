package com.wells.model;

import java.time.LocalDate;

public class Item {
	
	private Long icode;
	private String name;
	private Double price;
	private LocalDate packageDate;
	private Boolean fragile;
	
	public Item() {
		//left blank
	}

	public Item(Long icode, String name, Double price, LocalDate packageDate, Boolean fragile) {
		super();
		this.icode = icode;
		this.name = name;
		this.price = price;
		this.packageDate = packageDate;
		this.fragile = fragile;
	}

	public Long getIcode() {
		return icode;
	}

	public void setIcode(Long icode) {
		this.icode = icode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPackageDate() {
		return packageDate;
	}

	public void setPackageDate(LocalDate packageDate) {
		this.packageDate = packageDate;
	}

	public Boolean getFragile() {
		return fragile;
	}

	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
	}

	@Override
	public String toString() {
		return "Item [icode=" + icode + ", name=" + name + ", price=" + price + ", packageDate=" + packageDate
				+ ", fragile=" + fragile + "]";
	}
	
}
