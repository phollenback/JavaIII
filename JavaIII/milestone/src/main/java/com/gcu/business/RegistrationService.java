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
    public int initializeUser(SignUpModel user)
     {
        List<SignUpModel> users = service.findAll();

        for(SignUpModel signUp : users)
        {
            if(user.getUsername().equals(signUp.getUsername()))
            {
                // throw clear exception
                return -1;
            }
            else if (user.getEmail().equals(signUp.getEmail()))
            {
                return -2;
            }
            else if(user.getPhoneNumber().equals(signUp.getPhoneNumber()))
            {
                return -3;
            }
        }

        service.create(user);
        // verify in database, eventually
        return 1;
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
