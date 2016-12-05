/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            setVisible(true);
    }
       
         /**
     * The hideCartView method is used to set the Create new user View JFrame NOT visible
     */
       public void hideCartView() {
            setVisible(false);
    }
       
       private void createShoppingCartView(){
           
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel topRightPanel = new JPanel();
        topPanel.add(topRightPanel,BorderLayout.WEST);
         
        JPanel bottomPanel = new JPanel();
        panel.add(bottomPanel, BorderLayout.SOUTH);
      
        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(panel);

        //add product name  label
        productNameLabel = new JLabel("product Name");
        productNameLabel.setPreferredSize(new Dimension(200, 25));
        topPanel.add(productNameLabel);

        //add quantity label
        quantityLabel = new JLabel("Quantity");
        quantityLabel.setPreferredSize(new Dimension(200, 25));
        topPanel.add(quantityLabel);
        
        
        //adds the quantity selection combo box
        String[] quantityStrings = {"0","1", "2", "3", "4", "5"};
        quantityBox = new JComboBox(quantityStrings);
        quantityBox.setSelectedIndex(0);
        topPanel.add(quantityBox);

        //add price per unit label
        pricePunitLabel = new JLabel("price per unit");
        pricePunitLabel.setPreferredSize(new Dimension(200, 25));
        topPanel.add(pricePunitLabel);

        //add price per item  label
        pricePitemLabel = new JLabel("price per item");
        pricePitemLabel.setPreferredSize(new Dimension(200, 25));
        topPanel.add(pricePitemLabel);

        
        //***************************
        
        //populate here the UI with the products
        
         //***************************
        
        //add tax  label 
        taxLabel = new JLabel("Tax: $" +Double.toString(tax));
        taxLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(taxLabel);           
                          
        //add shipping price label 
        shippingPriceLabel = new JLabel("Shipping: $" + Double.toString(shippingPrice));
        shippingPriceLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(shippingPriceLabel);

        //add total price  label
        totalLabel = new JLabel("Total: $" + (Double.toString(tax + shippingPrice)));
        totalLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(totalLabel);
    
        //add continue shopping button to view
        buttonContShopping = new JButton("Continue Shopping");
        buttonContShopping.setPreferredSize(new Dimension(200, 25));
        buttonContShopping.addActionListener(new onClickGoBackToSystemView());
        bottomPanel.add(buttonContShopping);
        
          //add clear cart button to view
        buttonClearCart = new JButton("Clear Cart");
        buttonClearCart.setPreferredSize(new Dimension(200, 25));
        bottomPanel.add(buttonClearCart);
        
         //add checkout button to view
        buttonCheckout = new JButton("Checkout");
        buttonCheckout.setPreferredSize(new Dimension(200, 25));
        bottomPanel.add(buttonCheckout);
        
        getContentPane().add(panel); 
       }

    
    
      /**
     * onClickGoBackToSystemView
     *
     * @description create
     */
     private class onClickGoBackToSystemView implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            SystemView systemView = new SystemView();
            setVisible(false);
            systemView.showSystemView();            
        }
    }
}
