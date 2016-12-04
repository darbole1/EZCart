/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

/**
 *
 * @author Spinal
 */
public class InventoryItem extends Product
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
   
    
    private int quantity;
}
