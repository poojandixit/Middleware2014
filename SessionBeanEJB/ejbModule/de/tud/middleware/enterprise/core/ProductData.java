package de.tud.middleware.enterprise.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "product", catalog = "omazan")
@NamedQueries({
//	@NamedQuery(name="FetchByProductId", query=" SELECT OBJECT(a) FROM ProductData AS a WHERE a.id = ?1"),
	@NamedQuery(name="FetchAllProductItems", query=" SELECT OBJECT(a) FROM ProductData")
})
/*Entity containing product data*/
public class ProductData implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Attributes for Product details*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	String id;
	
	@Column(name = "name", nullable = false)
	String productName;
	
	public String getId() {
		return id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
