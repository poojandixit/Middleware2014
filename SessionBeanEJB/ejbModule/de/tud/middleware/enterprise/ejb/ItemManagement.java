/**
 * 
 */
package de.tud.middleware.enterprise.ejb;

import javax.ejb.Remote;

import de.tud.middleware.enterprise.core.ProductData;

/**
 * Interface to manage items in database: addition and deletion
 *
 */
@Remote // if client is not in the same JVM, if client is in the same JVM then use @Local
public interface ItemManagement {
	
	void addItemtoProductDB(ProductData productData);
	
	void removeItemfromProductDB(ProductData productData);

}
