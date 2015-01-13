package de.tud.middleware.enterprise.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import de.tud.middleware.enterprise.core.CustomerData;

@Stateful
@EJB(beanInterface = UserManagement.class, beanName = "UserManagementBean", name = "java:global/uManagement")
public class UserManagementBean implements UserManagement {

	/*
	 * EntityManager of an application manages several entity classes 
	 * such as CustomerData, ProductData and ItemCartData in this project
	 * using a persistence unit. You can view this from "persistence.xml" file.
	 * 
	 * 'unitName = "prod_cust_cart_mgm"' lets entityManager object to know
	 * which entity classes to refer to.
	 * 
	 * 'type = PersistenceContextType.EXTENDED' is or persistent context 
	 * to have lifetime across multiple transactions.
	 */
	@PersistenceContext(unitName = "prod_cust_cart_mgm", type = PersistenceContextType.EXTENDED)
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

	@Override
	public CustomerData fetchByCustomerId(String id) {
		// TODO Auto-generated method stub
//		Query query = entityManager.createNamedQuery("FetchByCustomerId");
//		query.setParameter(0, id);
//		return (CustomerData) (query.getSingleResult());
		return (CustomerData)entityManager.find(CustomerData.class, id);
	}

	@Override
	public List<CustomerData> fetchAllCustomers() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("FetchAllCustomers");
		return query.getResultList();
	}

}
