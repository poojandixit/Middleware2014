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
import javax.persistence.TypedQuery;

import de.tud.middleware.enterprise.core.ProductData;

@Stateful
@EJB(beanInterface = ItemManagement.class, beanName = "ItemManagementBean", name = "java:global/iManagement")
public class ItemManagementBean implements ItemManagement {

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

	@Override
	public List<ProductData> fetchAllProductItems() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("FetchAllProductItems");
		return query.getResultList();
	}

	@Override
	public ProductData fetchByProductId(String id) {
		// TODO Auto-generated method stub
//		Query query = entityManager.createNamedQuery("FetchByProductId");
//		query.setParameter(0, id);
//		return (ProductData) (query.getSingleResult());
		return (ProductData) entityManager.find(ProductData.class, id);
	}

}
