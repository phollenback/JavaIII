package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// import com.gcu.business.LoginService;
// import com.gcu.model.LoginModel;

import jakarta.validation.Valid;


@Controller
public class LoginController 
{

    // @Autowired
    // private LoginService ls;
    
   /**
     * Displays the login form view.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the login page
     */
    @GetMapping("/login")
    public String showLoginPage(Model model) {

        // Display Login Form View
        model.addAttribute("title", "Login Here!");
        return "login";
    }
    
}
