package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ez.Logger;
import ez.Serializer;
import java.io.IOException;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author DiegoArboleda
 */
public class createUserView extends JFrame {

    private JButton buttonCreate, buttonBackToSystemView;
    private JLabel firstNameLabel, lastNameLabel, userNameLabel, passwordLabel, accTypeLabel;
    private JTextField firstNameTextField, lastNameTextField, userNameTextField, passwordTextField;
    private JComboBox actTypeList;
    private int accType = 0;
    private boolean loggedIn;

    public createUserView() {
        //createNewUserView builds the create user view
        createNewUserView();
        setTitle("Register a New User");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * showNewUserView
     *
     * @description this method is used to set the Create new user View JFrame
     * visible
     */
    public void showNewUserView() {
        setVisible(true);
    }

    /**
     * hideNewUserView
     *
     * @description this method is used to set the Create new user View JFrame
     * NOT visible
     */
    public void hideNewUserView() {
        setVisible(false);
    }

    /**
     * createNewUserView
     *
     * @description creates the UI for the create a new user view of the
     * application
     */
    private void createNewUserView() {

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel topRightPanel = new JPanel();
        topPanel.add(topRightPanel, BorderLayout.WEST);

        JPanel bottomPanel = new JPanel();
        panel.add(bottomPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(panel);

        //add first name label 
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(firstNameLabel);

        //add the first name text field
        firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(firstNameTextField);

        //add last name label 
        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(lastNameLabel);

        //add the last name text field
        lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(lastNameTextField);

        //add user name label 
        userNameLabel = new JLabel("User Name:");
        userNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(userNameLabel);

        //add the username text field
        userNameTextField = new JTextField();
        userNameTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(userNameTextField);

        //add password label 
        passwordLabel = new JLabel("Password:");
        passwordLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(passwordLabel);

        //add the password field for the login page
        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(passwordTextField);

        //add Account type label & drop-down option
        accTypeLabel = new JLabel("Account Type:");
        accTypeLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(accTypeLabel);

        //add the dropdown to select a customer or seller
        String[] accountStrings = {"Customer", "Seller"};
        actTypeList = new JComboBox(accountStrings);
        actTypeList.setSelectedIndex(0);
        centerPanel.add(actTypeList);

        //add the "create user" button
        buttonCreate = new JButton("Create User");
        buttonCreate.setPreferredSize(new Dimension(200, 25));
        buttonCreate.addActionListener(new onClickCreateUser());
        centerPanel.add(buttonCreate);

        //add back to inventory view (main view) button
        buttonBackToSystemView = new JButton("Back To Inventory");
        buttonBackToSystemView.setPreferredSize(new Dimension(200, 25));
        buttonBackToSystemView.addActionListener(new onClickGoBackToSystemView());
        bottomPanel.add(buttonBackToSystemView);

        getContentPane().add(panel);
    }

    /**
     * onClickCreateUser
     *
     * @description this method reads, first name, last name, user name,
     * password and account type, then passes then as parameters to the register
     * method to create a new customer or seller and returns a message with the
     * result
     */
    private class onClickCreateUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String fName = userNameTextField.getText();
            String lName = passwordTextField.getText();
            String userN = userNameTextField.getText();
            String pwd = passwordTextField.getText();
            accType = actTypeList.getSelectedIndex();

            if ((fName.isEmpty()) || (lName.isEmpty()) || (userN.isEmpty()) || (pwd.isEmpty())) {
                JOptionPane.showMessageDialog(null, "All fields are required.", "Required Fields", YES_NO_OPTION);
            } else {

                Logger log = Logger.getInstance();
                String createUserResult = log.register(fName, lName, userN, pwd, accType);

                if (createUserResult.contains("successfully")) {

                    Serializer sz = new Serializer();
                    try {
                        sz.serializeAccounts(log.getAccounts(), log.getFileName());
                    } catch (IOException ex) {
                    }

                    JOptionPane.showMessageDialog(null, createUserResult);
                    SystemView systemView = new SystemView();
                    setVisible(false);
                    loggedIn = false;
                    systemView.showSystemView(loggedIn);
                } else {
                    JOptionPane.showMessageDialog(null, createUserResult);
                }
            }
        }
    }

    /**
     * onClickGoBackToSystemView
     *
     * @description this method takes the user back to the System view
     */
    private class onClickGoBackToSystemView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SystemView systemView = new SystemView();
            setVisible(false);
            loggedIn = false;
            systemView.showSystemView(loggedIn);
        }
    }
}
