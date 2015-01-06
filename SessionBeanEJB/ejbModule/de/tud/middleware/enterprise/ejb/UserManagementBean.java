package de.tud.middleware.enterprise.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.tud.middleware.enterprise.core.CustomerData;

public class UserManagementBean implements UserManagement {

	// For persistent context to have lifetime across multiple transactions
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	private CustomerData cData;
	
	@PostConstruct // below method is called when bean is created, just like constructor
	private void initializeBean() {
		cData = new CustomerData();
	}
	
	@Override
	// to invoke a business method within a transaction context
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addUsertoCustomerDB(CustomerData customerData) {
		// TODO Auto-generated method stub
		entityManager.persist(customerData);
	}

	@Override
	// to invoke a business method within a transaction context
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeUserfromCustomerDB(CustomerData customerData) {
		// TODO Auto-generated method stub
		entityManager.remove(customerData);
	}

}
