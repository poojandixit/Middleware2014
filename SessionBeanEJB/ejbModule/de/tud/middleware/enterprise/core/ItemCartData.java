package de.tud.middleware.enterprise.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemlist", catalog = "omazan")
/*
 * 'itemlist' table maintains the Customer ID <-> Product ID data.
 * Table has 3 fields. id, custid and prodid.
 * For every product per customer there is a new entry in the table.
 * such as:
 * |	id	|	custid	|	prodid	|
 * ----------------------------------
 * 		1		1			4
 * 		2		1			6
 * 		3		2			4
 * 		4		2			5
 * 		5		2			8
 * ----------------------------------
 * That means customer with id 1 has purchased two items with product ids 4 and 6.
 * And customer with id 2 has purchased three items with product ids 4,5 and 8.
 */
/*Class containing product data*/
public class ItemCartData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Attributes for ItemCart details*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	int id;
	
	@Column(name = "custid", nullable = false)
	int custid;
	
	@Column(name = "prodid", nullable = false)
	int prodid;

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getId() {
		return id;
	}
	
}
