package com.wellsfargo.fsd.imsa.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="items")
public class Item implements Serializable{
	
	@Id
	@Column(name="icode")
	@NotNull(message = "Item Code can not be omited")
	@Min(value = 1,message = "Item code cna not be zeroor negative")
	private Integer icode;
	
	@Column(name="title")
	@NotNull(message = "Title can not be omitted")
	@NotBlank(message = "Title can not be omitted")
	@Size(min = 5,max=20,message = "Title must be of 5 to 20 chars in length")
	private String title;
	
	@Column(name="packagedate")
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Package Date can not be omitted")
	@PastOrPresent(message = "Package date can not be a future date")
	private LocalDate packageDate;
	
	@Column(name="fragile")
	private Boolean fragile;
	
	@Column(name="unit")
	@NotNull(message = "Unit can not be omitted")
	@NotBlank(message = "Unit can not be omitted")
	@Size(min = 2,max=10,message = "Unit must be of 2 to 10 chars in length")
	private String unit;
	
	@Column(name="costprice")
	@NotNull(message = "Cost Price can not be omitted")
	@Min(value = 1,message = "Cost Price can not be zero or negative")
	private Double costPrice;
	
	@Column(name="sellingprice")
	@NotNull(message = "Selling Price can not be omitted")
	@Min(value = 1,message = "Selling Price can not be zero or negative")
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
