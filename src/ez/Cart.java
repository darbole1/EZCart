/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Spinal
 */
public class Cart implements Iterable<CartItem>
{
    /**Constructor for class Cart
     * Will instantiate the state of one object only for that class
     */
    private Cart()
    {
        this.cartCount = 0;
        this.totalCost = 0;
        itm = null;
        shoppingCart = new ArrayList();
    }
    
    /**Returns the only instance of the Cart class
     * @return The only object of the class Logger
     */
    public static Cart getInstance()
    {
        return cart;
    }
    
        @Override
    public Iterator<CartItem> iterator()
    {
        return shoppingCart.iterator();
    }
    
    public Iterator<CartItem> getInventoryItem()
    {
        return new
            Iterator<CartItem>()
            {
                @Override
                public boolean hasNext()
                {
                    return current < shoppingCart.size();
                }
                
                @Override
                public CartItem next()
                {
                    CartItem pd = shoppingCart.get(current);
                    current++;
                    return pd;
                }
                
                @Override
                public void remove()
                {
                    throw new UnsupportedOperationException();
                }
                
                private int current = 0;
            };
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
            shoppingCart.add(new CartItem(p.getName(), p.getUnitCost(), p.getUnitPrice(), p.getDescription()));
        }
    }
    
    /**Removes an cart item from the customer's cart
     * @param itm Cart Item to be removed from the customer's shopping cart
     */
    public void removeFromCart(CartItem itm)
    {
        shoppingCart.remove(itm);
    }
    
    /**Checks to see if an inventory item is already in the customer's cart
     * @param p inventory item to check for
     * @return True if item is already in cart, false otherwise
     */
    private boolean isItemInCart( InventoryItem p )
    {
        for( CartItem ci : shoppingCart )
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
        cartCount = shoppingCart.size();
        return cartCount;
    }    
        
    /**Calculates the total Cost for all items in the customer's 
     * shopping cart
     */
    public void calculateTotal()
    {
        for( CartItem ci : shoppingCart )
        {
            totalCost = ci.getQuantity() * ci.getUnitPrice();
        }
    }
    
    /**Clears the list that holds the cart items
     */
    public void clearShoppingCart()
    {
        //Check this method
        shoppingCart.clear();
    }
    
    private CartItem itm;
    private double totalCost;
    private int cartCount;
    private ArrayList<CartItem> shoppingCart;
    private static Cart cart = new Cart();
    //private static final long serialVersionID = 4L;
}
