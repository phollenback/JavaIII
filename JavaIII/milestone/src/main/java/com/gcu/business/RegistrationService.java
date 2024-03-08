package com.gcu.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataService;
import com.gcu.model.SignUpModel;


/**
 * The RegistrationService class provides methods for user registration.
 */
public class RegistrationService 
{
    @Autowired
    private UsersDataService service;
    /**
     * Initializes a user.
     * 
     * @param user The SignUpModel object representing the user to be initialized.
     * @return true if the user is successfully initialized, false otherwise.
     */
    public boolean initializeUser(SignUpModel user)
     {
        List<SignUpModel> users = service.findAll();

        for(SignUpModel signUp : users)
        {
            if(user.getUsername().equals(signUp.getUsername()) || 
                user.getEmail().equals(signUp.getEmail()) || 
                user.getPhoneNumber().equals(signUp.getPhoneNumber()))
            {
                return false;
            }
        }
        // verify in database, eventually
        return true;
    }
    
    /**
     * Initializes the RegistrationService.
     */
    public void init() {
        System.out.println("in RS.init");
    }

    /**
     * Destroys the RegistrationService.
     */
    public void destroy() {
        System.out.println("in RS.des");
    }
}
