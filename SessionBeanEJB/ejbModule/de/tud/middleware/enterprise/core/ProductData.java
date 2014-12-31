package de.tud.middleware.enterprise.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product", catalog = "omazan")
/*Class containing product data*/
public class ProductData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Attributes for Product details*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	int id;
	
	@Column(name = "name", nullable = false)
	String productName;
	
	public int getId() {
		return id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
