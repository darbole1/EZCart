/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.util.ArrayList;
import java.util.Iterator;


public class Inventory implements Iterable<Product>
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
    public Inventory getInstance()
    {
        return invt;
    }
    
    /**Adds a new product to the inventory
     * @param prod new product to be added
     */
    public void addNewProduct(Product prod)
    {
        inventory.add(prod);
    }
    
    /**Remove a product from the inventory
     * @param prodName name of product to be removed from the inventory
     */
    public void removeProduct( String prodName )
    {
        //IMPLEMENT THIS METHOND
    }
    
   
    @Override
    public Iterator<Product> iterator()
    {
        return inventory.iterator();
    }
    
    public Iterator<Product> getProducts()
    {
        return new
            Iterator<Product>()
            {
                @Override
                public boolean hasNext()
                {
                    return current < inventory.size();
                }
                
                @Override
                public Product next()
                {
                    Product pd = inventory.get(current);
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
        for(Product p : inventory )
        {
            cost = p.getUnitCost() * p.getQuantity();
        }
    }
    
    /**Calculates the revenue for all product in inventory*/
    private void calculateRevenue()
    {
        for(Product p : inventory )
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
    private static ArrayList<Product> inventory;
    private double profit; //Total profit on the whole inventory
    private double cost; //Total cost for the whole inventory
    private double revenue; //Total revenue on the whole inventory   
}
