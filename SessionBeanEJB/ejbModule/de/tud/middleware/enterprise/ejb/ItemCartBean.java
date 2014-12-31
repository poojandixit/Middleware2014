/**
 * 
 */
package de.tud.middleware.enterprise.ejb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.tud.middleware.enterprise.core.ProductData;

/**
 * Items added into cart and when checked out the itemlist table in the DB
 * is updated mapping customer ID to product ID
 *
 */

@Stateful
public class ItemCartBean implements ItemCart {
	
	// For persistent context to have lifetime across multiple transactions
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	private ArrayList<ProductData> pdList; 
	
	@PostConstruct // below method is called when bean is created, just like constructor
	private void initializeBean() {
		pdList = new ArrayList<ProductData>();
	}

	@Override
	public void addItemToCart(ProductData productData) {
		// TODO Auto-generated method stub
		pdList.add(productData);
	}

	@Override
	// to invoke a business method within a transaction context
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void checkOut() {
		// TODO Auto-generated method stub
		for(ProductData productData : pdList) {
			entityManager.persist(productData);
		}
		pdList.clear();
	}
	
}
