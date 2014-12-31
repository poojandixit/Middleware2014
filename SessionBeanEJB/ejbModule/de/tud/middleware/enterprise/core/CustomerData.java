package de.tud.middleware.enterprise.core;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Class containing customer data*/
public class CustomerData {
	/*Attributes for Customer details*/
	
	@Id // indicates primary key of current entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 
	@Column(name = "id", nullable = false)
	int id;
	
	@Column(name = "name", nullable = false)
	String customerName;
	
	ArrayList<Integer> itemsList = new ArrayList<Integer>(); // product id (foreign key in customer table)
	
	public int getId() {
		return id;
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
