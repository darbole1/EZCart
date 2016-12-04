/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;

/**
 *
 * @author DiegoArboleda
 */
public class cartView extends JFrame{
    
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
           
       }
}
