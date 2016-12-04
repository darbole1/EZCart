
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ez.Logger;

/**
 *
 * @author DiegoArboleda
 */
public class createUserView extends JFrame{
    
    private JButton buttonCreate;
    private JLabel firstNameLabel, lastNameLabel, userNameLabel, passwordLabel;
    private JTextField firstNameTextField, lastNameTextField, userNameTextField, passwordTextField;
    private int accType = 0; //o is a customer account, 1 is a seller account

    public createUserView(){
        //createNewUserView has shopping cart view
        createNewUserView();
    
        setTitle("Register a New User");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);      
        setSize(900, 600);       
        setLocationRelativeTo(null);        
        setResizable(false);
    }
    
    /**
     * The showNewUserView method is used to set the Create new user View JFrame visible
     */
       public void showNewUserView() {
        new createUserView().setVisible(true);
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

        //add first name label & text field
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(firstNameLabel);

        firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(firstNameTextField);

        //add last name label & text field
        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(lastNameLabel);

        lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(lastNameTextField);

        //add user name label & text field
        userNameLabel = new JLabel("User Name:");
        userNameLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(userNameLabel);

        userNameTextField = new JTextField();
        userNameTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(userNameTextField);
        
         //add password label & text field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setPreferredSize(new Dimension(200, 25));
        centerPanel.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(500, 25));
        centerPanel.add(passwordTextField);
        
        
        //need account type option here

        //create the "create user" button
        buttonCreate = new JButton("Create User");
        buttonCreate.setPreferredSize(new Dimension(200, 25));
        buttonCreate.addActionListener(new onClickCreateUser());
        centerPanel.add(buttonCreate);

        getContentPane().add(panel);
        
       }
    
      /**
     * onClickCreateUser
     *
     * @description 
     * 
     * 0 if it is a customer's account, 1 if it is a seller account
     */
     private class onClickCreateUser implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
         
           
            String fName = userNameTextField.getText();
            String lName = passwordTextField.getText();
            String userN = userNameTextField.getText();
            String pwd = passwordTextField.getText();
           // int accType = accountTypeSelection;
            int accType =1;
            
            Logger log = Logger.getInstance();
            String createUserResult = log.register(fName, lName, userN, pwd, accType);

            JOptionPane.showMessageDialog(null, createUserResult);
        }
    }
    
}
