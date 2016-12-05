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
public class InventoryItem extends Product implements Serializable
{
    public InventoryItem(String prodName, double cost, double price, String desc, int qty)
    {
        super( prodName, cost, price, desc);
        this.quantity = qty;
    }
    
    /**Returns the quantity for the given item in the inventory
     * @return current amount of that item in the inventory
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    public void updateQuantity(int qty )
    {
        this.quantity = qty;
    }
   
    
    private int quantity;
    private static final long serialVersionID = 3L;
}
