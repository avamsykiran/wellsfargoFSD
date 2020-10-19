package com.wellsfargo.batch5.basics.model;

public class Item {
	private Integer icode;
	private String itemName;
	private Double price;
	private String category;
	
	public Item() {
		
	}

	public Item(Integer icode, String itemName, Double price, String category) {
		super();
		this.icode = icode;
		this.itemName = itemName;
		this.price = price;
		this.category = category;
	}

	public Integer getIcode() {
		return icode;
	}

	public void setIcode(Integer icode) {
		this.icode = icode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [icode=" + icode + ", itemName=" + itemName + ", price=" + price + ", category=" + category + "]";
	}
	
	
}
