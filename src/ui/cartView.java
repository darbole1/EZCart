/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author DiegoArboleda
 */
public class cartView extends JFrame{
    
    private JButton buttonClearCart, buttonRemoveItem, buttonCheckout, buttonContShopping;
    private JLabel productNameLabel, quantityLabel, pricePunitLabel, pricePitemLabel, totalLabel, taxLabel, shippingPriceLabel;
   
    private JComboBox quantityBox;
    private double  tax = 3.00;
    private double  shippingPrice = 5.00;
     
     
    public cartView(){
          //createShoppingCartView builds the shopping cart view
        createShoppingCartView();
    
        setTitle("Register a New User");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);      
        setSize(900, 600);       
        setLocationRelativeTo(null);        
        setResizable(false);
    }
    
       /**
     * The showCartView method is used to set the Create new user View JFrame visible
     */
       public void showCartView() {
        new cartView().setVisible(true);
    }
       
         /**
     * The hideCartView method is used to set the Create new user View JFrame NOT visible
     */
       public void hideCartView() {
        new cartView().setVisible(false);
    }
       
       private void createShoppingCartView(){
           
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel topRightPanel = new JPanel();
        topPanel.add(topRightPanel,BorderLayout.WEST);
         
        JPanel bottomPanel = new JPanel();
        panel.add(bottomPanel, BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel();
        panel.add(leftPanel, BorderLayout.EAST);

        JPanel rightPanel = new JPanel();
        panel.add(rightPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(panel);

        //add product name  label
        productNameLabel = new JLabel("product Name");
        productNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(productNameLabel);

        //add quantity label
        quantityLabel = new JLabel("Quantity");
        quantityLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(quantityLabel);

        //add price per unit label
        pricePunitLabel = new JLabel("price per unit");
        pricePunitLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(pricePunitLabel);

        //add price per item  label
        pricePitemLabel = new JLabel("price per item");
        pricePitemLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(pricePitemLabel);

        //add tax  label 
        taxLabel = new JLabel("Tax: $" +Double.toString(tax));
        taxLabel.setPreferredSize(new Dimension(200, 25));
        bottomPanel.add(taxLabel);           
                          
        //add shipping price label 
        shippingPriceLabel = new JLabel("Shipping: $" + Double.toString(shippingPrice));
        shippingPriceLabel.setPreferredSize(new Dimension(200, 25));
        bottomPanel.add(shippingPriceLabel);

        //add total price  label
        totalLabel = new JLabel("Total: $" + (Double.toString(tax + shippingPrice)));
        totalLabel.setPreferredSize(new Dimension(200, 25));
        bottomPanel.add(totalLabel);


        
        //adds the quantity selection combo box
        String[] quantityStrings = {"0","1", "2", "3", "4", "5"};
        quantityBox = new JComboBox(quantityStrings);
        quantityBox.setSelectedIndex(0);
        centerPanel.add(quantityBox);
        
        
        
        getContentPane().add(panel); 
       }
}
