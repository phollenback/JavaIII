package com.gcu.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataService;
import com.gcu.model.LoginModel;
import com.gcu.model.SignUpModel;

/**
 * The Login Service that provides methods for user login 
 */
public class LoginService 
{
    @Autowired
    private UsersDataService service;

    /**
     * Checks that the user exists
     * @param user The LoginModel object representing the user being checked.
     * @return true if the user exists, false otherwise.
     */
    public boolean checkUserExistence(LoginModel user)
    {
        List<SignUpModel> users = service.findAll();

        // verify in database, eventually
        for(SignUpModel login : users)
        {
            if(user.getUsername().equals(login.getUsername()) &&
                user.getPassword().equals(login.getPassword()))
            {
                return true;
            }
        }
        // this will display an error
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