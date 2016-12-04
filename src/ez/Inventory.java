/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.util.ArrayList;
import java.util.Iterator;


public class Inventory implements Iterable<InventoryItem>
{
    private Inventory()
    {
        profit = 0;
        cost = 0;
        revenue = 0;
        inventory = new ArrayList();
    }
    
    /**Method that will return the only instance of that class
     * @return The only instance of the class
     */
    public static Inventory getInstance()
    {
        return invt;
    }
    
    /**Adds a new product to the inventory
     * @param item new product to be added
     */
    public void addNewProduct(InventoryItem item)
    {
        inventory.add(item);
    }
    
    /**Remove a product from the inventory
     * @param prodName name of product to be removed from the inventory
     */
    public void removeProduct( String prodName )
    {
        //IMPLEMENT THIS METHOND
    }
    
   
    @Override
    public Iterator<InventoryItem> iterator()
    {
        return inventory.iterator();
    }
    
    public Iterator<InventoryItem> getInventoryItem()
    {
        return new
            Iterator<InventoryItem>()
            {
                @Override
                public boolean hasNext()
                {
                    return current < inventory.size();
                }
                
                @Override
                public InventoryItem next()
                {
                    InventoryItem pd = inventory.get(current);
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
    
    /**Calculates the cost for all product in inventory*/
    private void calculateCost()
    {
        for(InventoryItem p : inventory )
        {
            cost = p.getUnitCost() * p.getQuantity();
        }
    }
    
    /**Calculates the revenue for all product in inventory*/
    private void calculateRevenue()
    {
        for(InventoryItem p : inventory )
        {
            revenue = p.getUnitPrice() * p.getQuantity();
        }
    }
    
    /**Calculates the profit on all products in the inventory*/
    private void calculateProfit()
    {
        profit = revenue - cost;
    }
    
    /**Returns the revenue for all products
     @return revenue*/
    public double getRevenue()
    {
        invt.calculateRevenue();
        return revenue;
    }
    
    /**Returns the cost for all products currently in inventory
     @return cost*/
    public double getCost()
    {
        invt.calculateCost();
        return cost;
    }
    
    /**Returns the profit for all products currently in inventory
     @return profit*/
    public double getProfit()
    {
        invt.calculateProfit();
        return profit;
    }
    
    private static Inventory invt = new Inventory();
    private static ArrayList<InventoryItem> inventory;
    private double profit; //Total profit on the whole inventory
    private double cost; //Total cost for the whole inventory
    private double revenue; //Total revenue on the whole inventory   
}
