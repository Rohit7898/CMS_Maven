package com.cms.model;

public class Menu_Item {
	private int n;
	private int itemId;
	private String itemName;
	private float itemPrice;
	private String itemImage;
	private int vendorId;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((itemImage == null) ? 0 : itemImage.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + Float.floatToIntBits(itemPrice);
		result = prime * result + vendorId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu_Item other = (Menu_Item) obj;
		if (itemId != other.itemId)
			return false;
		if (itemImage == null) {
			if (other.itemImage != null)
				return false;
		} else if (!itemImage.equals(other.itemImage))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Float.floatToIntBits(itemPrice) != Float.floatToIntBits(other.itemPrice))
			return false;
		if (vendorId != other.vendorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Menu_Item []";
	}
	
	public Menu_Item() {
		super();
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Menu_Item(int n, int itemId, String itemName, float itemPrice, String itemImage, int vendorId) {
		super();
		this.n = n;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		this.vendorId = vendorId;
	}
	
}
