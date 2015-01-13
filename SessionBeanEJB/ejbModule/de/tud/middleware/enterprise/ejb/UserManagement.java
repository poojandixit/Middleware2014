package de.tud.middleware.enterprise.ejb;

import java.util.List;

import javax.ejb.Remote;

import de.tud.middleware.enterprise.core.CustomerData;

/**
 * Interface to manage users in database: addition and deletion
 *
 */

@Remote // if client is not in the same JVM, if client is in the same JVM then use @Local
public interface UserManagement {

	void addUsertoCustomerDB(CustomerData customerData);
	
	void removeUserfromCustomerDB(CustomerData customerData);
	
	CustomerData fetchByCustomerId(String id);
	
	List<CustomerData> fetchAllCustomers();
	
}
