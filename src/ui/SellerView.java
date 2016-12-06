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

/**
 *
 * @author DiegoArboleda
 */
public class SellerView extends JFrame {

    private JButton buttonUpdateCart, buttonLogOut, buttonRemoveProd, buttonAddNewProd;
    private JLabel productNameLabel, loggedUser;
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
          
            centerPanel.add(productDtlsTextField);

            buttonUpdateCart = new JButton("Update Product");
            buttonUpdateCart.setPreferredSize(new Dimension(100, 25));
            buttonUpdateCart.addActionListener(new onClickAddUpdateproduct());
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
        buttonAddNewProd.addActionListener(new onClickOpenWindowToCreateNewProduct());
        bottomPanel.add(buttonAddNewProd);
        getContentPane().add(panel);
    }

    /**
     * onClickAddProductToInventory
     *
     * @description calls
     */
    private class onClickAddUpdateproduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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
            labelsPanel.add(new JLabel("Please Update Product name: ", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Update Product Description:", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Update Product Quantity:", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Update Product Cost:", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Update Product Price:", SwingConstants.RIGHT));
            mainPanel.add(labelsPanel, BorderLayout.WEST);

            JPanel ProductPanel = new JPanel(new GridLayout(0, 1, 2, 2));
            ProductPanel.add(pName);
            ProductPanel.add(pDescription);
            ProductPanel.add(pQuantity);
            ProductPanel.add(pCost);
            ProductPanel.add(pPrice);
            mainPanel.add(ProductPanel, BorderLayout.CENTER);

            int result = JOptionPane.showConfirmDialog(null, mainPanel,
                    "Update Product Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {

                //add code here to update 
            }

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
     * onClickOpenWindowToCreateNewProduct
     *
     * @description calls
     */
    private class onClickOpenWindowToCreateNewProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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
            labelsPanel.add(new JLabel("Please Enter new Product name: ", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Enter Product Description:", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Enter Product Quantity:", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Enter Product Cost:", SwingConstants.RIGHT));
            labelsPanel.add(new JLabel("Please Enter Product Price:", SwingConstants.RIGHT));
            mainPanel.add(labelsPanel, BorderLayout.WEST);

            JPanel newProductPanel = new JPanel(new GridLayout(0, 1, 2, 2));
            newProductPanel.add(pName);
            newProductPanel.add(pDescription);
            newProductPanel.add(pQuantity);
            newProductPanel.add(pCost);
            newProductPanel.add(pPrice);
            mainPanel.add(newProductPanel, BorderLayout.CENTER);

            int result = JOptionPane.showConfirmDialog(null, mainPanel,
                    "Please Enter Product Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {

                inventory.addNewProduct(pName.getText(), Double.parseDouble(pCost.getText()), Double.parseDouble(pPrice.getText()), pDescription.getText(), Integer.parseInt(pQuantity.getText()));
            productDtlsTextField.setText(pDescription.getText());
            }
        }
    }
}
