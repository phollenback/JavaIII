package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.SignUpModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/signup")
    public String showSignUpPage(Model model) 
    {
        
        // Display Sign Up Form View
        model.addAttribute("title", "Sign Up Form");
        model.addAttribute("signUpModel", new SignUpModel());
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Display Login Form View
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        // check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        return "redirect:/home";
    }

    @PostMapping("/doSignUp")
    public String doSignUp(@Valid SignUpModel signUpModel, BindingResult bindingResult, Model model) 
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Sign Up Form");
            return "signup";
        }

        return "redirect:/home";
    }
}

