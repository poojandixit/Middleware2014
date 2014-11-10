package de.tud.middleware.gui;

import java.util.ArrayList;

/*Class containing customer data*/
public class CustomerData {
	/*Attributes for Customer details*/
	int id;
	String customerName;
	ArrayList<ProductData> itemsList = new ArrayList<ProductData>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ArrayList<ProductData> getItemsList() {
		return itemsList;
	}
	public void setItemsList(ArrayList<ProductData> itemsList) {
		this.itemsList = itemsList;
	}
	
}
