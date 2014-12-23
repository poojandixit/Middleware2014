package de.tud.middleware.core;

import java.util.ArrayList;

/*Class containing customer data*/
public class CustomerData {
	/*Attributes for Customer details*/
	int id;
	String customerName;
	ArrayList<Integer> itemsList = new ArrayList<Integer>(); // product id (foreign key in customer table)
	
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
	public ArrayList<Integer> getItemsList() {
		return itemsList;
	}
	public void setItemsList(ArrayList<Integer> itemsList) {
		this.itemsList = itemsList;
	}
	
}
