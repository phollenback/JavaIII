package com.gcu.business;
import com.gcu.model.LoginModel;

/**
 * The Login Service that provides methods for user login 
 */
public class LoginService 
{
    /**
     * Checks that the user exists
     * @param user The LoginModel object representing the user being checked.
     * @return true if the user exists, false otherwise.
     */
    public boolean checkUserExistence(LoginModel user)
    {
        // verify in database, eventually
        if (user.getUsername().equals("JohnDoe23") && user.getPassword().equals("Pazzword23")) {
            return true;
        }
        return false;
    }
    
    /**
     * Initializes the Login Service.
     */
    public void init()
    {
        System.out.println("in LS.init");
    }

    /**
     * Destroys the Login Service.
     */
    public void destroy()
    {
        System.out.println("in LS.des");
    }
}