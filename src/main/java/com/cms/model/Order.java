package com.cms.model;

import java.sql.Date;
import java.sql.Time;

public class Order {
	private int OrderId;
	private int ItemId;
	private int EmployeeId;
	private int Quantity;
	private Date date;
	private Time time;
	private int TokenNo; 
	private	int  VendorId;
	private float TotalPrice;
    private int Status;
	private String Message;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, int itemId, int employeeId, int quantity, Date date, Time time, int tokenNo, int vendorId,
			float totalPrice, int status, String message) {
		super();
		OrderId = orderId;
		ItemId = itemId;
		EmployeeId = employeeId;
		Quantity = quantity;
		this.date = date;
		this.time = time;
		TokenNo = tokenNo;
		VendorId = vendorId;
		TotalPrice = totalPrice;
		Status = status;
		Message = message;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getTokenNo() {
		return TokenNo;
	}
	public void setTokenNo(int tokenNo) {
		TokenNo = tokenNo;
	}
	public int getVendorId() {
		return VendorId;
	}
	public void setVendorId(int vendorId) {
		VendorId = vendorId;
	}
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EmployeeId;
		result = prime * result + ItemId;
		result = prime * result + ((Message == null) ? 0 : Message.hashCode());
		result = prime * result + OrderId;
		result = prime * result + Quantity;
		result = prime * result + Status;
		result = prime * result + TokenNo;
		result = prime * result + Float.floatToIntBits(TotalPrice);
		result = prime * result + VendorId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Order other = (Order) obj;
		if (EmployeeId != other.EmployeeId)
			return false;
		if (ItemId != other.ItemId)
			return false;
		if (Message == null) {
			if (other.Message != null)
				return false;
		} else if (!Message.equals(other.Message))
			return false;
		if (OrderId != other.OrderId)
			return false;
		if (Quantity != other.Quantity)
			return false;
		if (Status != other.Status)
			return false;
		if (TokenNo != other.TokenNo)
			return false;
		if (Float.floatToIntBits(TotalPrice) != Float.floatToIntBits(other.TotalPrice))
			return false;
		if (VendorId != other.VendorId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", ItemId=" + ItemId + ", EmployeeId=" + EmployeeId + ", Quantity="
				+ Quantity + ", date=" + date + ", time=" + time + ", TokenNo=" + TokenNo + ", VendorId=" + VendorId
				+ ", TotalPrice=" + TotalPrice + ", Status=" + Status + ", Message=" + Message + "]";
	}
	
}
