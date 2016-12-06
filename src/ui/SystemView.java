
package ui;

import ez.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author DiegoArboleda
 */
public class SystemView extends JFrame{
    
    private JButton buttonLogin, buttonCreateUser,buttonAddToCart, buttonCartView, buttonLogOut;
    private JLabel productNameLabel, loggedUser;
    private JTextField  productDtlsTextField;  
    boolean loggedIn;
    private String userLoggedIn;
    
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
     * The showSystemView method is used to set the LoginView JFrame visible
     */
    public void showSystemView(boolean loggedIn){
        
        if(loggedIn)
        {
            buttonLogin.setVisible(false);
            buttonCreateUser.setVisible(false);
            buttonCartView.setVisible(true);
            buttonLogOut.setVisible(true);
            setVisible(true);
        }
        else{
            setVisible(true);
            buttonCartView.setVisible(false);
        }
}
    
      public void showSystemViewAfterLogin(boolean loggedIn, String uName){
        
        if(loggedIn)
        {
            userLoggedIn = uName;
            buttonLogin.setVisible(false);
            buttonCreateUser.setVisible(false);
            buttonCartView.setVisible(true);
            buttonLogOut.setVisible(true);
            loggedUser.setText("Logged in as, " + userLoggedIn);
            loggedUser.setVisible(true);
            setVisible(true);
        }
        else{
              setVisible(true);
              buttonCartView.setVisible(false);
        }
}
    
       /**
     * The hideSystemView method is used to set the LoginView JFrame NOT visible
     */
    public void hideSystemView(){
        setVisible(false);
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
        
        //label for logged user
        loggedUser= new JLabel();
        loggedUser.setPreferredSize(new Dimension(200, 25));
        loggedUser.setVisible(false);
        topRightPanel.add(loggedUser);
        
        //add the cart view button
        buttonCartView= new JButton("See Shopping Cart");
        buttonCartView.setPreferredSize(new Dimension(200, 25));
        buttonCartView.setVisible(false);
        buttonCartView.addActionListener( new onClickNavigateToCartView());
        topRightPanel.add(buttonCartView);
        
        buttonLogOut= new JButton("Log Out");
        buttonLogOut.setPreferredSize(new Dimension(200, 25));
        buttonLogOut.setVisible(false);
        buttonLogOut.addActionListener( new onClickLogOut());
        topRightPanel.add(buttonLogOut);
        
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
            hideSystemView();
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
            hideSystemView();
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
     
      /**
     * onClickNavigateToCartView
     *
     * @description creates an instance of the createUserView class and calls the
     * method showNewUserView() to navigate to the Login Page
     */
     private class onClickNavigateToCartView implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            cartView CartView = new cartView();
            CartView.showCartView();
            hideSystemView();
            
        }
    }
     
       /**
     * onClickLogOut
     *
     * @description creates 
     */
     private class onClickLogOut implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
           loggedIn = false;
            Logger log = Logger.getInstance();
            //log.logout();
            
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
