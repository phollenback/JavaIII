package com.gcu.business;
import com.gcu.model.SignUpModel;

public class RegistrationService 
{

    public boolean initializeUser(SignUpModel user)
    {
        // verify in database, eventually
        if(user.getEmail() == "generic.email.com")
        {
            return false;
        }
        return true;
    }
    
    public void init()
    {
        System.out.println("in RS.init");
    }

    public void destroy()
    {
        System.out.println("in RS.des");
    }
}
