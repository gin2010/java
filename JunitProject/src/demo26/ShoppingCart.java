package demo26;

import java.util.Iterator;

public interface ShoppingCart { 
/**
* Add this many of this item to the
* shopping cart.
*/
public void addItems(Item anItem, int quantity) throws NegativeCountException;
/**
* Delete this many of this item from the
* shopping cart
*/
public void deleteItems(Item anItem,int quantity) throws NegativeCountException,NoSuchItemException;
/**
* Count of all items in the cart
* (that is, all items x qty each)
*/
public int itemCount();
/**
* Return Iterator of all items
* (see Java Collection¡¯s doc)
*/
public Iterator iterator();
}