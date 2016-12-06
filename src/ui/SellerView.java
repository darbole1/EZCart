package ui;

import ez.Inventory;
import ez.InventoryItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import ez.Logger;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 * @author DiegoArboleda
 */
public class SellerView extends JFrame {

    private JButton buttonUpdateCart, buttonLogOut, buttonRemoveProd, buttonAddNewProd;
    private JButton buttonCalcCost, buttonCalcProfit, buttonCalcRevenue;
    private JLabel productNameLabel, loggedUser, productDtlsLabel, productCostLabel, productPriceLabel, productQuantityLabel;
    private JTextField productDtlsTextField, pName, pDescription, pQuantity, pCost, pPrice;
    private boolean loggedIn;
    private String userLoggedIn;
    private int actType;
    SystemView sellerView = new SystemView();
    Logger log = Logger.getInstance();
    Inventory inventory = Inventory.getInstance();

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
        loggedUser.setText("Logged in as " + userLoggedIn);
        setVisible(true);
    }

    /**
     * The hideSellerView method is used to set the SellerView JFrame NOT
     * visible
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

        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(panel);

        //////////////// HEADER LABELS
        
         //add product label Headers
            productNameLabel = new JLabel("Name: ");
            productNameLabel.setPreferredSize(new Dimension(150, 25));
            topPanel.add(productNameLabel, BorderLayout.SOUTH);

            //add product details  label
            productDtlsLabel = new JLabel("Description: ");
            productDtlsLabel.setPreferredSize(new Dimension(150, 25));
            topPanel.add(productDtlsLabel, BorderLayout.SOUTH);
            
             //add product cost label
            productCostLabel = new JLabel("Cost: ");
            productCostLabel.setPreferredSize(new Dimension(100, 25));
            topPanel.add(productCostLabel, BorderLayout.SOUTH);
            
              //add product price label
            productPriceLabel = new JLabel("Price: ");
            productPriceLabel.setPreferredSize(new Dimension(100, 25));
            topPanel.add(productPriceLabel, BorderLayout.SOUTH);
            
              //add product quantity label
            productQuantityLabel = new JLabel("Quantity: ");
            productQuantityLabel.setPreferredSize(new Dimension(100, 25));
            topPanel.add(productQuantityLabel, BorderLayout.SOUTH);

                 
        
        /////////////////
       Iterator<InventoryItem> itm = inventory.getInventoryItem();        
       
            while(itm.hasNext()) {
        
            InventoryItem item = itm.next();
            //add product name label
            productNameLabel = new JLabel("Name: " + item.getName());
            productNameLabel.setPreferredSize(new Dimension(150, 25));
            centerPanel.add(productNameLabel);

            //add product details  label
            productDtlsLabel = new JLabel("Description: " + item.getDescription());
            productDtlsLabel.setPreferredSize(new Dimension(150, 25));
            centerPanel.add(productDtlsLabel);
            
             //add product cost label
            productCostLabel = new JLabel("Cost: " + item.getUnitCost());
            productCostLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productCostLabel);
            
              //add product price label
            productPriceLabel = new JLabel("Price: " + item.getUnitPrice());
            productPriceLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productPriceLabel);
            
              //add product quantity label
            productQuantityLabel = new JLabel("Quantity: " + item.getQuantity());
            productQuantityLabel.setPreferredSize(new Dimension(100, 25));
            centerPanel.add(productQuantityLabel);

            buttonUpdateCart = new JButton("Update");
            buttonUpdateCart.setPreferredSize(new Dimension(100, 25));
            buttonUpdateCart.addActionListener(new onClickOpenUpdateProductWindow());
            centerPanel.add(buttonUpdateCart);

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

        buttonLogOut = new JButton("Log Out");
        buttonLogOut.setPreferredSize(new Dimension(200, 25));
        buttonLogOut.setVisible(true);
        buttonLogOut.addActionListener(new onClickLogOutOfSellerView());
        topRightPanel.add(buttonLogOut);

        buttonAddNewProd = new JButton("Add New Product");
        buttonAddNewProd.setPreferredSize(new Dimension(200, 25));
        buttonAddNewProd.setVisible(true);
        buttonAddNewProd.addActionListener(new onClickOpenCreateNewProduct());
        bottomPanel.add(buttonAddNewProd, BorderLayout.NORTH);

        //button to calculate revenue
        buttonCalcRevenue = new JButton("Calculate Revenue");
        buttonCalcRevenue.setPreferredSize(new Dimension(200, 25));
        buttonCalcRevenue.setVisible(true);
        buttonAddNewProd.addActionListener(new onClickCalculateRevenue());
        bottomPanel.add(buttonCalcRevenue, BorderLayout.EAST);

        //button to calculate cost
        buttonCalcCost = new JButton("Calculate Cost");
        buttonCalcCost.setPreferredSize(new Dimension(200, 25));
        buttonCalcCost.setVisible(true);
        buttonAddNewProd.addActionListener(new onClickCalculateCost());
        bottomPanel.add(buttonCalcCost, BorderLayout.CENTER);

        //button to calculate profit
        buttonCalcProfit = new JButton("Calculate Profit");
        buttonCalcProfit.setPreferredSize(new Dimension(200, 25));
        buttonCalcProfit.setVisible(true);
        buttonAddNewProd.addActionListener(new onClickCalculateProfit());
        bottomPanel.add(buttonCalcProfit, BorderLayout.WEST);

        getContentPane().add(panel);
    }

    /**
     * onClickOpenUpdateProductWindow
     *
     * @description Opens the pop-up that allows the customer/seller to update
     * product details
     */
    private class onClickOpenUpdateProductWindow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int result = createProductPopUp("Update Product Details");

            if (result == JOptionPane.OK_OPTION) {

                //add code here to update 
            }
        }
    }

    /**
     * onClickCalculateProfit
     *
     * @description O
     */
    private class onClickCalculateProfit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**
     * onClickCalculateCost
     *
     * @description Opens
     */
    private class onClickCalculateCost implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**
     * onClickCalculateRevenue
     *
     * @description Opens
     */
    private class onClickCalculateRevenue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

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
     * @params popUpTitle - the title which is assigned to the pop-up window
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
     * onClickOpenWindowToCreateNewProduct
     *
     * @description calls
     */
    private class onClickOpenCreateNewProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int result = createProductPopUp("Enter Product Details");

            if (result == JOptionPane.OK_OPTION) {

                inventory.addNewProduct(pName.getText(), Double.parseDouble(pCost.getText()), Double.parseDouble(pPrice.getText()), pDescription.getText(), Integer.parseInt(pQuantity.getText()));
             
                
            }
        }
    }
}
