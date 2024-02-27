package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.RegistrationService;

@Configuration
public class SpringConfig 
{
    @Bean(name="registrationService", initMethod="init", destroyMethod="destroy")
    public RegistrationService getSignUp()
    {
        return new RegistrationService();
    }
    
}
