package ui;

import ez.Inventory;
import ez.InventoryItem;
import ez.InventoryListener;
import ez.Logger;
import ez.Serializer;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author DiegoArboleda
 */
public class SellerView extends JFrame {

    private JButton buttonUpdateCart, buttonLogOut, buttonRemoveProd, buttonAddNewProd;
    private JButton buttonCalcCost, buttonCalcProfit, buttonCalcRevenue;
    private JPanel centerPanel;
    private JLabel productNameLabel, loggedUser, productDtlsLabel, productCostLabel, productPriceLabel, productQuantityLabel;
    private JTextField pName, pDescription, pQuantity, pCost, pPrice;
    private boolean loggedIn;
    private String userLoggedIn;
    SystemView sellerView = new SystemView();
    Logger log = Logger.getInstance();
    Inventory inventory = Inventory.getInstance();

    public SellerView() {
        InventoryListener iL = new InventoryListener(this);
        inventory.addListener(iL);

        createSellerView();
        setTitle("The Seller EZ Shopping cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * showSellerView
     *
     * @description this method is used to set the SellerView JFrame visible
     * @param userName - holds the username of the user that is currently logged
     * in
     */
    public void showSellerView(String userName) {
        userLoggedIn = userName;
        loggedUser.setText("Logged in as " + userLoggedIn);
        setVisible(true);
    }

    /**
     * hideSellerView
     *
     * @description this method is used to set the SellerView JFrame NOT visible
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

        JPanel bottomPanel = new JPanel(new BorderLayout());
        panel.add(bottomPanel, BorderLayout.SOUTH);

        centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(panel);

        //-------- HEADER LABELS
        //add product label Headers
        productNameLabel = new JLabel("Name: ");
        productNameLabel.setPreferredSize(new Dimension(150, 25));
        centerPanel.add(productNameLabel);

        //add product details  label
        productDtlsLabel = new JLabel("Description: ");
        productDtlsLabel.setPreferredSize(new Dimension(150, 25));
        centerPanel.add(productDtlsLabel);

        //add product cost label
        productCostLabel = new JLabel("Cost: ");
        productCostLabel.setPreferredSize(new Dimension(100, 25));
        centerPanel.add(productCostLabel);

        //add product price label
        productPriceLabel = new JLabel("Price: ");
        productPriceLabel.setPreferredSize(new Dimension(100, 25));
        centerPanel.add(productPriceLabel);

        //add product quantity label
        productQuantityLabel = new JLabel("Quantity: ");
        productQuantityLabel.setPreferredSize(new Dimension(300, 25));
        centerPanel.add(productQuantityLabel);

        Iterator<InventoryItem> itm = inventory.getInventoryItem();
        updateInventoryView(itm, centerPanel);

        //label for logged user
        loggedUser = new JLabel();
        loggedUser.setPreferredSize(new Dimension(200, 25));
        loggedUser.setVisible(true);
        topRightPanel.add(loggedUser);

        //add the log out button
        buttonLogOut = new JButton("Log Out");
        buttonLogOut.setPreferredSize(new Dimension(200, 25));
        buttonLogOut.setVisible(true);
        buttonLogOut.addActionListener(new onClickLogOutOfSellerView());
        topRightPanel.add(buttonLogOut);

        //add the Add new product button
        buttonAddNewProd = new JButton("Add New Product");
        buttonAddNewProd.setPreferredSize(new Dimension(200, 25));
        buttonAddNewProd.addActionListener(new onClickOpenCreateNewProduct());
        bottomPanel.add(buttonAddNewProd, BorderLayout.NORTH);

        //add the button to calculate revenue
        buttonCalcRevenue = new JButton("Calculate Revenue");
        buttonCalcRevenue.setPreferredSize(new Dimension(200, 25));
        buttonCalcRevenue.addActionListener(new onClickCalculateRevenue());
        bottomPanel.add(buttonCalcRevenue, BorderLayout.EAST);

        //add the button to calculate cost
        buttonCalcCost = new JButton("Calculate Cost");
        buttonCalcCost.setPreferredSize(new Dimension(200, 25));
        buttonCalcCost.addActionListener(new onClickCalculateCost());
        bottomPanel.add(buttonCalcCost, BorderLayout.CENTER);

        //add the button to calculate profit
        buttonCalcProfit = new JButton("Calculate Profit");
        buttonCalcProfit.setPreferredSize(new Dimension(200, 25));
        buttonCalcProfit.addActionListener(new onClickCalculateProfit());
        bottomPanel.add(buttonCalcProfit, BorderLayout.WEST);

        getContentPane().add(panel);
    }

    /**
     * onClickOpenUpdateProductWindow
     *
     * @description Opens the pop-up that allows the seller to update product
     * details
     */
    private class onClickOpenUpdateProductWindow implements ActionListener {

        Iterator<InventoryItem> itm = inventory.getInventoryItem();

        public onClickOpenUpdateProductWindow(Iterator<InventoryItem> itm) {
            this.itm = itm;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int result = createProductPopUp("Update Product Details");
            if (result == JOptionPane.OK_OPTION) {
                inventory.updateProduct(itm.next(), pName.getText(), Double.parseDouble(pCost.getText()), Double.parseDouble(pPrice.getText()), pDescription.getText(), Integer.parseInt(pQuantity.getText()));

            }
        }
    }

    /**
     * onClickLogOutOfSellerView
     *
     * @description Logs out the user and removes permissions only available to
     * seller
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
     * createProductPopUp
     *
     * @description creates a pop-up window which allows the customer/seller to
     * add, update product details
     * @param popUpTitle - the title which is assigned to the pop-up window
     * @return userSelection - the choice selected by the customer/seller
     */
    public int createProductPopUp(String popUpTitle) {

        pName = new JTextField();
        pDescription = new JTextField();
        pQuantity = new JTextField();
        pCost = new JTextField();
        pPrice = new JTextField();

        pName.setPreferredSize(new Dimension(100, 25));
        pDescription.setPreferredSize(new Dimension(100, 25));
        pQuantity.setPreferredSize(new Dimension(100, 25));
        pCost.setPreferredSize(new Dimension(100, 25));
        pPrice.setPreferredSize(new Dimension(100, 25));

        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));

        JPanel labelsPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        labelsPanel.add(new JLabel("Product name: ", SwingConstants.RIGHT));
        labelsPanel.add(new JLabel("Product Description:", SwingConstants.RIGHT));
        labelsPanel.add(new JLabel("Product Quantity:", SwingConstants.RIGHT));
        labelsPanel.add(new JLabel("Product Cost:", SwingConstants.RIGHT));
        labelsPanel.add(new JLabel("Product Price:", SwingConstants.RIGHT));
        mainPanel.add(labelsPanel, BorderLayout.WEST);

        JPanel newProductPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        newProductPanel.add(pName);
        newProductPanel.add(pDescription);
        newProductPanel.add(pQuantity);
        newProductPanel.add(pCost);
        newProductPanel.add(pPrice);
        mainPanel.add(newProductPanel, BorderLayout.CENTER);

        int userSelection = JOptionPane.showConfirmDialog(null, mainPanel,
                popUpTitle, JOptionPane.OK_CANCEL_OPTION);
        return userSelection;
    }

    /**
     * onClickOpenCreateNewProduct
     *
     * @description shows a pop up asking the seller to enter the required info
     * to add a new product to the inventory
     */
    private class onClickOpenCreateNewProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int result = createProductPopUp("Enter Product Details");

            if (result == JOptionPane.OK_OPTION) {
                inventory.addNewProduct(pName.getText(), Double.parseDouble(pCost.getText()), Double.parseDouble(pPrice.getText()), pDescription.getText(), Integer.parseInt(pQuantity.getText()));
                Serializer sz = new Serializer();
                try {
                    sz.serializeInventory(inventory.getInventory(), inventory.getFileName());
                } catch (IOException ex) {
                }
            }
        }
    }

    /**
     * onClickCalculateProfit
     *
     * @description calls the function which calculates the profit
     */
    private class onClickCalculateProfit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Your Profit is $" + inventory.getProfit());
        }
    }

    /**
     * onClickCalculateCost
     *
     * @description calls the function which calculates the cost
     */
    private class onClickCalculateCost implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Your Cost is $" + inventory.getCost());
        }
    }

    /**
     * onClickCalculateRevenue
     *
     * @description calls the function which calculates the revenue
     */
    private class onClickCalculateRevenue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Your Revenue is $" + inventory.getRevenue());
        }
    }

    /**
     * onClickRemoveProdFromInventory
     *
     * @description remove a product from the inventory
     */
    private class onClickRemoveProdFromInventory implements ActionListener {

        Iterator<InventoryItem> itm = inventory.getInventoryItem();

        public onClickRemoveProdFromInventory(Iterator<InventoryItem> itm) {
            this.itm = itm;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inventory.removeProduct(itm.next());
        }
    }

    /**
     * updateInventoryView
     *
     * @description this method re-builds the inventory view with the products
     * from the inventory and their properties
     * @param itm - reference to an inventory item
     * @param centerPanel - the panel where the inventory products will be
     * placed
     */
    public void updateInventoryView(Iterator<InventoryItem> itm, JPanel centerPanel) {
        while (itm.hasNext()) {

            InventoryItem item = itm.next();
            //add product name label
            productNameLabel = new JLabel(item.getName());
            productNameLabel.setPreferredSize(new Dimension(150, 25));
            centerPanel.add(productNameLabel);

            //add product details  label
            productDtlsLabel = new JLabel(item.getDescription());
            productDtlsLabel.setPreferredSize(new Dimension(150, 25));
            centerPanel.add(productDtlsLabel);

            //add product cost label
            productCostLabel = new JLabel(Double.toString(item.getUnitCost()));
            productCostLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productCostLabel);

            //add product price label
            productPriceLabel = new JLabel(Double.toString(item.getUnitPrice()));
            productPriceLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productPriceLabel);

            //add product quantity label
            productQuantityLabel = new JLabel(Integer.toString(item.getQuantity()));
            productQuantityLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productQuantityLabel);

            //add button to update cart
            buttonUpdateCart = new JButton("Update");
            buttonUpdateCart.setPreferredSize(new Dimension(100, 25));
            buttonUpdateCart.addActionListener(new onClickOpenUpdateProductWindow(itm));
            centerPanel.add(buttonUpdateCart);

            //add button to remove a product
            buttonRemoveProd = new JButton("Remove");
            buttonRemoveProd.setPreferredSize(new Dimension(100, 25));
            buttonRemoveProd.setVisible(true);
            buttonRemoveProd.addActionListener(new onClickRemoveProdFromInventory(itm));
            centerPanel.add(buttonRemoveProd);
        }
    }
}
