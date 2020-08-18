package com.wellsfargo.fsd.ims.entity;

import java.time.LocalDate;

public class Item {

	private Integer icode;
	private String title;
	private LocalDate packageDate;
	private Boolean fragile;
	private String unit;
	private Double costPrice;
	private Double sellingPrice;
	
	public Item() {
		//left unimplemente
	}

	public Item(Integer icode, String title, LocalDate packageDate, Boolean fragile, String unit, Double costPrice,
			Double sellingPrice) {
		super();
		this.icode = icode;
		this.title = title;
		this.packageDate = packageDate;
		this.fragile = fragile;
		this.unit = unit;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
	}

	public Integer getIcode() {
		return icode;
	}

	public void setIcode(Integer icode) {
		this.icode = icode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Override
	public String toString() {
		return "Item [icode=" + icode + ", title=" + title + ", packageDate=" + packageDate + ", fragile=" + fragile
				+ ", unit=" + unit + ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice + "]";
	}
}
