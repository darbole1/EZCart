package ui;

import ez.Cart;
import ez.Inventory;
import ez.InventoryItem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author DiegoArboleda
 */
public class SystemView extends JFrame {

    private JButton buttonLogin, buttonCreateUser, buttonAddToCart, buttonCartView, buttonLogOut;
    private JLabel productNameLabel, loggedUser, productDtlsLabel, productPriceLabel;
    private boolean loggedInFlag;
    private String userLoggedIn;
    Inventory inventory = Inventory.getInstance();
    Cart cart = Cart.getInstance();

    public SystemView() {

        //createView has main page 'system' which is the inventory view
        createSystemView();
        setTitle("The EZ Shopping cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * showSystemView
     *
     * @description This method is used to set the LoginView JFrame visible
     * @param loggedIn - used as a flag to verify if the user is logged in to
     * show or hide certain buttons
     */
    public void showSystemView(boolean loggedIn) {

        if (loggedIn) {
            buttonLogin.setVisible(false);
            buttonCreateUser.setVisible(false);
            buttonCartView.setVisible(true);
            buttonLogOut.setVisible(true);
            setVisible(true);
        } else {
            setVisible(true);
            buttonCartView.setVisible(false);
        }
    }

    /**
     * showSystemView
     *
     * @description This method is used to set the LoginView JFrame visible
     * @param loggedIn - used as a flag to verify if the user is logged in to
     * show or hide certain buttons
     * @param uName - used to hold the user name, to show, "logged in as, user "
     */
    public void showSystemViewAfterLogin(boolean loggedIn, String uName) {

        if (loggedIn) {
            userLoggedIn = uName;
            buttonLogin.setVisible(false);
            buttonCreateUser.setVisible(false);
            buttonCartView.setVisible(true);
            buttonLogOut.setVisible(true);
            loggedUser.setText("Logged in as " + userLoggedIn);
            loggedInFlag = true;
            loggedUser.setVisible(true);
            setVisible(true);
        } else {
            setVisible(true);
            buttonCartView.setVisible(false);
        }
    }

    /**
     * hideSystemView
     *
     * @description The method is used to set the LoginView JFrame NOT visible
     */
    public void hideSystemView() {
        setVisible(false);
    }

    /**
     * createSystemView
     *
     * @description creates the UI for the main System view of the application
     */
    private void createSystemView() {

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel topRightPanel = new JPanel();
        topPanel.add(topRightPanel, BorderLayout.WEST);

        JPanel bottomPanel = new JPanel();
        panel.add(bottomPanel, BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel();
        panel.add(leftPanel, BorderLayout.EAST);

        JPanel rightPanel = new JPanel();
        panel.add(rightPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(panel);

        //add product name label HEADER
        productNameLabel = new JLabel("product Name: ");
        productNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(productNameLabel);

        //add product details label HEADER
        productDtlsLabel = new JLabel("Description: ");
        productDtlsLabel.setPreferredSize(new Dimension(250, 25));
        centerPanel.add(productDtlsLabel);

        //add product price label
        productPriceLabel = new JLabel("Price: ");
        productPriceLabel.setPreferredSize(new Dimension(250, 25));
        centerPanel.add(productPriceLabel);

        Iterator<InventoryItem> itm = inventory.getInventoryItem();
        updateProductsView(itm, centerPanel);

        //add the button to login
        buttonLogin = new JButton("Login");
        buttonLogin.setPreferredSize(new Dimension(200, 25));
        buttonLogin.addActionListener(new onClickNavigateToLoginPage());
        topRightPanel.add(buttonLogin);

        //add the button to create a user
        buttonCreateUser = new JButton("Create new user");
        buttonCreateUser.setPreferredSize(new Dimension(200, 25));
        buttonCreateUser.addActionListener(new onClickNavigateToCreateUserPage());
        topRightPanel.add(buttonCreateUser);

        //label for logged user
        loggedUser = new JLabel();
        loggedUser.setPreferredSize(new Dimension(200, 25));
        loggedUser.setVisible(false);
        topRightPanel.add(loggedUser);

        //add the cart view button
        buttonCartView = new JButton("See Shopping Cart");
        buttonCartView.setPreferredSize(new Dimension(200, 25));
        buttonCartView.setVisible(false);
        buttonCartView.addActionListener(new onClickNavigateToCartView());
        topRightPanel.add(buttonCartView);

        //add the button to log out
        buttonLogOut = new JButton("Log Out");
        buttonLogOut.setPreferredSize(new Dimension(200, 25));
        buttonLogOut.setVisible(false);
        buttonLogOut.addActionListener(new onClickLogOut());
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
     * @description creates an instance of the createUserView class and calls
     * the method showNewUserView() to navigate to the Login Page
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

        Iterator<InventoryItem> cartItem = inventory.getInventoryItem();

        public onClickAddProductToCart(Iterator<InventoryItem> cartItem) {
            this.cartItem = cartItem;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (loggedInFlag) {
                cart.addToCart(cartItem.next());
                JOptionPane.showMessageDialog(rootPane, "Addition to Cart Successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Please Login to continue with your purchase.", "Login Required", YES_NO_OPTION);
            }
        }
    }

    /**
     * onClickNavigateToCartView
     *
     * @description creates an instance of the createUserView class and calls
     * the method showNewUserView() to navigate to the Login Page
     */
    private class onClickNavigateToCartView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cartView CartView = new cartView();
            CartView.showCartView(userLoggedIn);
            hideSystemView();
        }
    }

    /**
     * onClickLogOut
     *
     * @description changes the state between true and false of those labels or
     * info that a user should/should not see
     */
    private class onClickLogOut implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loggedInFlag = false;
            buttonLogin.setVisible(true);
            buttonCreateUser.setVisible(true);
            buttonCartView.setVisible(false);
            buttonLogOut.setVisible(false);
            loggedUser.setVisible(false);
        }
    }

    /**
     * updateProductsView
     *
     * @description changes the state between true and false of those labels or
     * info that a user should/should not see
     * @param itm - the inventory item objects
     * @param centerPanel - the panel where the elements will be placed
     */
    public void updateProductsView(Iterator<InventoryItem> itm, JPanel centerPanel) {
        while (itm.hasNext()) {

            InventoryItem item = itm.next();
            //add product name label
            productNameLabel = new JLabel(item.getName());
            productNameLabel.setPreferredSize(new Dimension(200, 25));
            centerPanel.add(productNameLabel);

            //add product details  label
            productDtlsLabel = new JLabel(item.getDescription());
            productDtlsLabel.setPreferredSize(new Dimension(200, 25));
            centerPanel.add(productDtlsLabel);

            //add product price label
            productPriceLabel = new JLabel("" + item.getUnitPrice());
            productPriceLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productPriceLabel);

            buttonAddToCart = new JButton("Add to Cart");
            buttonAddToCart.setPreferredSize(new Dimension(200, 25));
            buttonAddToCart.addActionListener(new onClickAddProductToCart(itm));
            centerPanel.add(buttonAddToCart);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemView().setVisible(true);
            }
        });

    }
}
