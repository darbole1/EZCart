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
public class Inventory 
{
    private Inventory()
    {
        profit = 0;
        cost = 0;
        revenue = 0;
    }
    
    /**Method that will return the only instance of that class
     * @return The only instance of the class
     */
    public Inventory getInstance()
    {
        return invt;
    }
    
    
    private static Inventory invt = new Inventory(); 
    private double profit;
    private double cost;
    private double revenue;    
}
