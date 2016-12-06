package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import ez.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DiegoArboleda
 */
public class SellerView extends JFrame {

    private JButton buttonAddToCart, buttonCartView, buttonLogOut, buttonRemoveProd;
    private JLabel productNameLabel, loggedUser;
    private JTextField productDtlsTextField;
    private boolean loggedIn;
    private String userLoggedIn;
    private int actType;
    SystemView sellerView = new SystemView();
    Logger log = Logger.getInstance();

    public SellerView() {

        createSellerView();

        setTitle("The Seller EZ Shopping cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * The showSellerView method is used to set the SellerView JFrame visible
     */
    public void showSellerView(String userName) {
        userLoggedIn = userName;
        loggedUser.setText("Logged in as, " + userLoggedIn);
        setVisible(true);        
    }

    /**
     * The hideSellerView method is used to set the SellerView JFrame NOT visible
     */
    public void hideSellerView() {
        setVisible(false);
    }

    /**
     * createSellerView
     *
     * @description creates the UI for the seller view of the application
     */
    private void createSellerView() {

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

            buttonAddToCart = new JButton("Add to Cart");
            buttonAddToCart.setPreferredSize(new Dimension(100, 25));
            buttonAddToCart.addActionListener(new onClickAddProductToInventory());
            centerPanel.add(buttonAddToCart);

            buttonRemoveProd = new JButton("Remove");
            buttonRemoveProd.setPreferredSize(new Dimension(100, 25));
            buttonRemoveProd.setVisible(true);
            //  buttonRemoveProd.addActionListener(new onClickRemoveProdFromInventory());
            centerPanel.add(buttonRemoveProd);
        }

        //label for logged user
        loggedUser = new JLabel();
        loggedUser.setPreferredSize(new Dimension(200, 25));
        loggedUser.setVisible(true);
        topRightPanel.add(loggedUser);

        //add the cart view button
        buttonCartView = new JButton("See Inventory Cart");
        buttonCartView.setPreferredSize(new Dimension(200, 25));
        buttonCartView.setVisible(true);
        buttonCartView.addActionListener(new onClickNavigateToInventoryCartView());
        topRightPanel.add(buttonCartView);

        buttonLogOut = new JButton("Log Out");
        buttonLogOut.setPreferredSize(new Dimension(200, 25));
        buttonLogOut.setVisible(true);
        buttonLogOut.addActionListener(new onClickLogOutOfSellerView());
        topRightPanel.add(buttonLogOut);

        getContentPane().add(panel);
    }

    /**
     * onClickAddProductToInventory
     *
     * @description calls
     */
    private class onClickAddProductToInventory implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //if addition to inventory is successful or not, show message accordingly
            JOptionPane.showMessageDialog(rootPane, "Addition to inventory Successful!");
            JOptionPane.showMessageDialog(rootPane, "Addition to inventory NOT Successful!");
        }
    }

    /**
     * onClickLogOutOfSellerView
     *
     * @description calls
     */
    private class onClickLogOutOfSellerView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
 
            loggedIn = false;
            SystemView systemView = new SystemView();
            systemView.showSystemView(loggedIn);
            hideSellerView();
        }
    }

    /**
     * onClickNavigateToInventoryCartView
     *
     * @description calls
     */
    private class onClickNavigateToInventoryCartView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
