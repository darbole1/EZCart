/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.io.Serializable;

/**
 *
 * @author Spinal
 */
public class CartItem extends Product implements Serializable
{
    public CartItem(String prodName, double cost, double price, String desc)
    {
        super( prodName, cost, price, desc);
        quantity = 1;
    }
    
    /**Updates the quantity for a product
     @param qty New quantity for the given product
    */
    public void updateQuantity(int qty)
    {
        quantity = qty;
    }
    
        /**Returns the quantity for the current product
     * @return current quantity for product
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    private int quantity;   
    private static final long serialVersionID = 5L;
}
