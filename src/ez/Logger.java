/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez;

import java.util.ArrayList;

public class Logger 
{
    /**Definition of the Logger Constructor*/
    private Logger()
    {
        //List that will hold all of the accounts in the system
        Accounts = new ArrayList<>();
    }
    
    /**Returns the only instance of the Logger class
     * @return The only object of the class Logger
     */
    public static Logger getInstance()
    {
        return logEn;
    }
    
    /**Register a new customer to the system first by verifying that the username is unique,
     and the password meets the criteria for security purpose
     * @param first Customer's first name
     * @param last Customer's last name
     * @param userN Customer's chosen username
     * @param pwd Customer's chosen password
     * @param accType Type for the account
     * @return Message to user to display status of account
     */
    public String register(String first, String last, String userN, String pwd, int accType)
    {
        if(!checkUsernameAvail(userN))
        {
            return "The username " + userN + " is already taken.\nPlease choose"
                    + " another username";
        }
        else
        {
            if(validatePassword(pwd))
            {
                Account acc = new Account(first, last, userN, pwd, accType);
                Accounts.add(acc);
                return "Account successfully created";
            }
            else
            {
                return "Password must contain at least:\n"
                        + "One digit\n"
                        + "One upper case letter\n"
                        + "One lower case letter\n"
                        + "One special character\n"
                        + "Password must be at least eight(8) characters long";
            }
        }
    }
    
    /**Checks the availability of a username chosen by the user.
     * User will me alerted about the status of the userName
     * @param userN Username to be validated
     * @return message to the user regarding the availability of the username
     */
    private boolean checkUsernameAvail( String userN )
    {
        boolean avail = true;
        
        for( Account acc : Accounts )
        {
            if (acc.getUserName().equals(userN))
            {
                return (!avail);
            }
        }
        
        return avail;
    }
    
    /**Validates a password to see if it meets security requirements
     * Returns true if validated, false otherwise
     * @param pwd Password to be validated
     * @return true if password is good, false otherwise
     */
    private boolean validatePassword( String pwd )
    {
        boolean validated = false; //Verifies that password is completely validated
        boolean pwdLength = false;
        boolean upperCase = false; //Verifies that password contains an upperCase letter
        boolean lowerCase = false; //Verifies that password contains a lowerCase letter
        boolean digit = false; //Verifies that password contains a digit
        boolean specialChar = false; //Verifies that password contains a special character
        char symbol;
        
        //Check to see if pwd is 8 character long
        if(pwd.length() >= PWDLEN )
        {
            pwdLength = true;
        }
        
        for(int i = 0; i < pwd.length(); i++)
        {
            symbol =  pwd.charAt(i);
            
            //Check for upperCase
            if(Character.isUpperCase(symbol))
            {
                upperCase = true;
            }
            
            //Check for lower case
            if(Character.isLowerCase(symbol))
            {
                lowerCase = true;
            }
            
            //Check for Digit
            if(Character.isDigit(symbol))
            {
                digit = true;
            }
            
            //Check for special character
            if(!(Character.isLetterOrDigit(symbol) && Character.isSpaceChar(symbol)))
            {
                specialChar = true;
            }            
        } //end of for
        
        if( pwdLength && upperCase && lowerCase && digit && specialChar )
        {
            validated = true;
        }
        
        return validated;
    }
    
    /**Method that will log customer in the system
     * @param userN username entered by user
     * @param pwd password entered by user
     * @return message to indicate to user whether login was successful
     * or not
     */
    public String login(String userN, String pwd)
    {
        if(logEn.validateCredentials(userN, pwd))        
        {
            return "Logged in successfully";
        }
        else
        {
            return "Username and Password combination is not correct\n";
        }
    }
    
    /**Checks to see if information provided
     * by user to log in is valid
     * @param userN username provided by the user to be validated
     * @param pwd password provided by user to be validated
     * @return 
     */
    private boolean validateCredentials(String userN, String pwd)
    {
        boolean validated = false;
        
        for( Account acc : Accounts )
        {
            if(acc.getUserName().equals(userN))
            {
                if(acc.getPassword().equals(pwd))
                {
                    validated = true;
                }
            }
        }
                
        return validated;
    }
    
    private static Logger logEn = new Logger();
    private ArrayList<Account> Accounts;
    final private int PWDLEN = 8;
}
