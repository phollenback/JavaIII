package com.gcu.business;
import com.gcu.model.SignUpModel;


/**
 * The RegistrationService class provides methods for user registration.
 */
public class RegistrationService {

    /**
     * Initializes a user.
     * 
     * @param user The SignUpModel object representing the user to be initialized.
     * @return true if the user is successfully initialized, false otherwise.
     */
    public boolean initializeUser(SignUpModel user) {
        // verify in database, eventually
        if (user.getEmail().equals("generic.email.com")) {
            return false;
        }
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
