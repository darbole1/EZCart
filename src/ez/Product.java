
package ez;

/**
 * @author Spinal
 */
public class Product 
{
    /**Constructor for a product
     * @param prodName Name of the product
     * @param qty Quantity for the given product
     * @param cost Cost for the product
     * @param price Price per unity for the product
     * @param desc Description details for the product
     */
    public Product( String prodName, int qty, double cost, double price, String desc )
    {
        this.name = prodName;
        this.quantity = qty;
        this.unitCost = cost;
        this.unitPrice = price;
        this.description = desc;
    }
    
    /**Returns the name of the product
     * @return name of the product
     */
    public String getName()
    {
        return name;
    }
    
    /**Returns the quantity for the current product
     * @return current quantity for product
     */
    public int getQuantity()
    {
        return quantity;
    }
   
    /** Returns the unit price for the current product
     * @return The price for the given product
     */
    public double getUnitPrice()
    {
        return unitPrice;
    }
    
    /**
    Returns the description for the current product
    @return The product's description
    */
    public String getDescription()
    {
        return description;
    }
    
    /**Updates the quantity for a product
     @param qty New quantity for the given product
    */
    public void updateQuantity(int qty)
    {
        quantity = qty;
    }
    
    
    private String name;
    private int quantity;
    private double unitPrice;
    private double unitCost;
    private String description;    
}
