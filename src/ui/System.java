/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SOLO CALI
 */
public class System extends JFrame{
    
    private JButton buttonLogin, buttonCreateuser,buttonAddtoCart;
    private JLabel userNameLabel, passwordLabel, backgroundLabel, productNameLabel;
    private JTextField userNameTextField, passwordTextField, productDtlsTextField;
    private ImageIcon icon;
    
    public System(){
        
        //createView has basic login ui
        //createView();
        
         //createView has main page 'system' which is the inventory view
          createSystemView();
    
        setTitle("The EZ Shopping cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        setSize(900, 600);       
        setLocationRelativeTo(null);        
        setResizable(false);
       
        
        
}
    
    private void createView(){
        JPanel panel = new JPanel();   
        getContentPane().add(panel);
        
     
        
        //add username label
        userNameLabel= new JLabel("User Name:");
        userNameLabel.setPreferredSize(new Dimension(200, 25));
        panel.add(userNameLabel);
        
        //add username  text fields
        userNameTextField= new JTextField();
        userNameTextField.setPreferredSize(new Dimension(200, 25));
        panel.add(userNameTextField);
        
         //add passsword labels
        passwordLabel= new JLabel("Password:");
        passwordLabel.setPreferredSize(new Dimension(200, 25));
        panel.add(passwordLabel);
            
       
         //add passsword text fields
        passwordTextField= new JTextField();
        passwordTextField.setPreferredSize(new Dimension(200, 25));
        panel.add(passwordTextField);
        
        buttonLogin= new JButton("Login");
        buttonLogin.setPreferredSize(new Dimension(200, 25));
        panel.add(buttonLogin);
        
        buttonCreateuser= new JButton("Create new user");
        buttonCreateuser.setPreferredSize(new Dimension(200, 25));
        panel.add(buttonCreateuser);
        
       
    }
    
    private void createSystemView(){
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
     
       
        
        for (int x = 0; x < 5; x++) {
            
            //add product name label
            productNameLabel = new JLabel("product Name:");
            productNameLabel.setPreferredSize(new Dimension(200, 25));
            centerPanel.add(productNameLabel);

            //add product details  text field
            productDtlsTextField = new JTextField();
            productDtlsTextField.setPreferredSize(new Dimension(350, 25));  
            productDtlsTextField.setText("here goes some product details");
            centerPanel.add(productDtlsTextField);
            
            buttonAddtoCart= new JButton("Add to Cart");
            buttonAddtoCart.setPreferredSize(new Dimension(200, 25));
            centerPanel.add(buttonAddtoCart);
            
        }
        
        
        buttonLogin= new JButton("Login");
        buttonLogin.setPreferredSize(new Dimension(200, 25));
        buttonLogin.addActionListener(
                new navigateToLoginPage()
        );
        topRightPanel.add(buttonLogin);
        
        buttonCreateuser= new JButton("Create new user");
        buttonCreateuser.setPreferredSize(new Dimension(200, 25));
        topRightPanel.add(buttonCreateuser);
        
         getContentPane().add(panel);
    }
       
    
    public static void main(String[] args){
         java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new System().setVisible(true);
            }
        });
  
        
    }

    private class navigateToLoginPage implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginView loginView = new LoginView();
            loginView.showLoginView();
        }
    }
    
}
