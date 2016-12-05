
package ez;

import java.io.Serializable;


/**
 *
 * @author Spinal
 */
public class Account implements Serializable
{
    /**Account constructor
     * @param fName Customer's first name
     * @param lName Customer's last name
     * @param user Customer's username
     * @param pwd Customer's password
     * @param type The type of account: either Customer or Seller Account
     * For Customer account, type = 0
     * For Seller account, type = 1
     */
    public Account( String fName, String lName, String user, String pwd, int type )
    {
        firstName = fName;
        lastName = lName;
        userName = user;
        password = pwd;
        accountType = type;
    }
    
    /**Returns the username for the current account
     * @return username for the current account
     */
    public String getUserName()
    {
        return userName;
    }
    
    /**Returns the password for the current account
     * @return Password for the current account
     */
    public String getPassword()
    {
        return password;
    }
    
    /**Returns the account type to determine whether the current account
     * is for a customer or a seller
     * @return 0 if it is a customer's account, 1 if it is a seller account
     */
    public int getAccountType()
    {
        return accountType;
    }
            
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int accountType; 
    private static final long serialVersionID = 1L; 
}
