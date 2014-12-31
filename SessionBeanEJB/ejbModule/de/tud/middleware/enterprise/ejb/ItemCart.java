/**
 * 
 */
package de.tud.middleware.enterprise.ejb;

import javax.ejb.Remote;

import de.tud.middleware.enterprise.core.ProductData;

/**
 * Interface to add items to the cart
 *
 */
@Remote // if client is not in the same JVM, if client is in the same JVM then use @Local
public interface ItemCart {
	
	void addItemToCart(ProductData productData);
	
	void checkOut();

}
