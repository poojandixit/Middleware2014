/**
 * 
 */
package de.tud.middleware.enterprise.ejb;

import javax.ejb.Remote;

import de.tud.middleware.enterprise.core.ItemCartData;
import de.tud.middleware.enterprise.core.ProductData;

/**
 * Interface to add items to the cart
 *
 */
@Remote // if client is not in the same JVM, if client is in the same JVM then @Local can be used
public interface ItemCart {
	
	void addItemToCart(ItemCartData itemCartData);
	
	void checkOut();

}
