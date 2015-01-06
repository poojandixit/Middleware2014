package de.tud.middleware.enterprise.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.tud.middleware.enterprise.core.ProductData;

@Stateful
public class ItemManagementBean implements ItemManagement {

	// For persistent context to have lifetime across multiple transactions
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	private ProductData pData;
	
	@PostConstruct // below method is called when bean is created, just like constructor
	private void initializeBean() {
		pData = new ProductData();
	}
	
	@Override
	// to invoke a business method within a transaction context
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addItemtoProductDB(ProductData productData) {
		// TODO Auto-generated method stub
		entityManager.persist(productData);
	}

	@Override
	// to invoke a business method within a transaction context
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeItemfromProductDB(ProductData productData) {
		// TODO Auto-generated method stub
		entityManager.remove(productData);
	}

}
