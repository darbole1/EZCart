/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Spinal
 */
public class Cart implements Serializable
{
    /**Constructor for class Cart
     * Will instantiate the state of one object only for that class
     */
    private Cart()
    {
        this.cartCount = 0;
        this.totalCost = 0;
        itm = null;
        cartItems = new ArrayList();
    }
    
    /**Returns the only instance of the Cart class
     * @return The only object of the class Logger
     */
    public static Cart getInstance()
    {
        return shoppingCart;
    }
    
    /**Returns the total cost of all items in cart
     * @return totalCost
     */
    public double getTotalCost()
    {
        return totalCost;
    }
    
    public void addToCart(InventoryItem p)
    {
        //Check to see if product is not alreay in cart
        if(isItemInCart( p ))
        {
            int quan = itm.getQuantity();
            quan++;
            itm.updateQuantity(quan);            
        }
        else
        {
            cartItems.add(new CartItem(p.getName(), p.getUnitCost(), p.getUnitPrice(), p.getDescription()));
        }
    }
    
    /**Removes an cart item from the customer's cart
     * @param itm Cart Item to be removed from the customer's shopping cart
     */
    public void removeFromCart(CartItem itm)
    {
        cartItems.remove(itm);
    }
    
    /**Checks to see if an inventory item is already in the customer's cart
     * @param p inventory item to check for
     * @return True if item is already in cart, false otherwise
     */
    private boolean isItemInCart( InventoryItem p )
    {
        for( CartItem ci : cartItems )
        {
            if(p.getName().equals(ci.getName()))
            {
                itm = ci;
                return true;
            }
        }
        return false;
    }
    
    /**Returns the amount of shopping cart items in the shopping cart
     * @return amount of cart items in shopping cart
     */
    public int getCount()
    {
        cartCount = cartItems.size();
        return cartCount;
    }    
        
    /**Calculates the total Cost for all items in the customer's 
     * shopping cart
     */
    public void calculateTotal()
    {
        for( CartItem ci : cartItems )
        {
            totalCost = ci.getQuantity() * ci.getUnitPrice();
        }
    }
    
    /**Clears the list that holds the cart items
     */
    public void clearShoppingCart()
    {
        //Check this method
        cartItems.clear();
    }
    
    private CartItem itm;
    private double totalCost;
    private int cartCount;
    private ArrayList<CartItem> cartItems;
    private static Cart shoppingCart = new Cart();
    private static final long serialVersionID = 4L;
}
