
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DiegoArboleda
 */
public class SystemView extends JFrame{
    
    private JButton buttonLogin, buttonCreateUser,buttonAddToCart;
    private JLabel productNameLabel;
    private JTextField  productDtlsTextField;  
    
    public SystemView(){
                       
        //createView has main page 'system' which is the inventory view
        createSystemView();

        setTitle("The EZ Shopping cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);    
}   
    
    /**
     * createSystemView
     *
     * @description creates the UI for the main System view of the application
     */
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
            
            buttonAddToCart= new JButton("Add to Cart");
            buttonAddToCart.setPreferredSize(new Dimension(200, 25));
            buttonAddToCart.addActionListener( new onClickAddProductToCart());
            centerPanel.add(buttonAddToCart);            
        }
                
        buttonLogin= new JButton("Login");
        buttonLogin.setPreferredSize(new Dimension(200, 25));
        buttonLogin.addActionListener( new onClickNavigateToLoginPage());
        topRightPanel.add(buttonLogin);
        
        buttonCreateUser= new JButton("Create new user");
        buttonCreateUser.setPreferredSize(new Dimension(200, 25));
        buttonCreateUser.addActionListener( new onClickNavigateToCreateUserPage());
        topRightPanel.add(buttonCreateUser);
        
        getContentPane().add(panel);
    }
       
      

    /**
     * navigateToLoginPage
     *
     * @description creates an instance of the LoginView class and calls the
     * method showLoginPage() to navigate to the Login Page
     */
    private class onClickNavigateToLoginPage implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginView loginView = new LoginView();
            loginView.showLoginView();
        }
    }
    
    /**
     * navigateToCreateUserPage
     *
     * @description creates an instance of the createUserView class and calls the
     * method showNewUserView() to navigate to the Login Page
     */
     private class onClickNavigateToCreateUserPage implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            createUserView userView = new createUserView();
            userView.showNewUserView();
        }
    }
     
      /**
     * onClickAddProductToCart
     *
     * @description calls the required method to add a product to the cart and
     * shows a message to the user weather the addition was successful or not
     */
     private class onClickAddProductToCart implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //if addition to cart is successful or not, show message accordingly
            JOptionPane.showMessageDialog(rootPane, "Addition to Cart Successful!");
            JOptionPane.showMessageDialog(rootPane, "Addition to Cart NOT Successful!");
            
//            createUserView userView = new createUserView();
//            userView.showNewUserView();
        }
    }
     
     public static void main(String[] args){
         java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new SystemView().setVisible(true);
            }
        });  
        
    }
}
