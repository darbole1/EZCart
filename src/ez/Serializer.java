/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.io.*;
import java.util.*;
/**
 *
 * @author Spinal
 */
public class Serializer 
{
    public Serializer()
    {}
    
    /**Method that will serialize the account list in a binary file
     * This methods throws an IOException: must be handled
     * @param acc The list of accounts to be serialized
     * @param fileName name of file where list is to be serialized
     * @throws java.io.IOException
     */
    public void serializeAccounts(ArrayList<Account> acc, String fileName) throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        
        out.writeObject(acc);
        out.close();
    }
    
    /**Method that will serialize the account list in a binary file
     * This methods throws an IOException: must be handled
     * @param inv The list of accounts to be serialized
     * @param fileName name of file where list is to be serialized
     * @throws java.io.IOException
     */
    public void serializeInventory(ArrayList<InventoryItem> inv, String fileName) throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        
        out.writeObject(inv);
        out.close();
    }
    
    /**Method that will serialize the account list in a binary file
     * This methods throws an IOException: must be handled
     * @param shoppingCart The list of accounts to be serialized
     * @param fileName name of file where list is to be serialized
     * @throws java.io.IOException
     */
    public void serializeCart(ArrayList<CartItem> shoppingCart, String fileName) throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        
        out.writeObject(shoppingCart);
        out.close();
    }
    
    /**Method that will de-serialize the account list from the binary file
     * This
     * @param fileName the filename where the binary object is to be found
     * @return ArrayList that will contain the accounts
     */
    public ArrayList<Account> deSerializeAccounts( String fileName ) 
    {
        ArrayList<Account> accDes = null;
        
        try (ObjectInputStream in = new ObjectInputStream( new FileInputStream(fileName))) {
            accDes = (ArrayList<Account>)in.readObject();
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return accDes;
    }
    
    /**Method that will de-serialize the account list from the binary file
     * This
     * @param fileName the filename where the binary object is to be found
     * @return ArrayList that will contain the accounts
     */
    public ArrayList<InventoryItem> deSerializeInventory( String fileName ) 
    {
        ArrayList<InventoryItem> invDes = null;
        
        try (ObjectInputStream in = new ObjectInputStream( new FileInputStream(fileName))) {
            invDes = (ArrayList<InventoryItem>)in.readObject();
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return invDes;
    }
    
    /**Method that will de-serialize the account list from the binary file
     * This
     * @param fileName the filename where the binary object is to be found
     * @return ArrayList that will contain the accounts
     */
    public ArrayList<CartItem> deSerializeShoopingCart( String fileName ) 
    {
        ArrayList<CartItem> cart = null;
        
        try (ObjectInputStream in = new ObjectInputStream( new FileInputStream(fileName))) {
            cart = (ArrayList<CartItem>)in.readObject();
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return cart;
    }
}
