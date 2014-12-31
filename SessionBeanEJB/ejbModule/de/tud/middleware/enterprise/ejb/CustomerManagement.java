/**
 * 
 */
package de.tud.middleware.enterprise.ejb;

import javax.ejb.Remote;

/**
 * Interface to manage users in database: addition and deletion
 * of users.
 *
 */
@Remote // if client is not in the same JVM, if client is in the same JVM then use @Local
public interface CustomerManagement {
	
	void addUserIntoCustomerDB();
	
	void removeUserFromCustomerDB();

}
