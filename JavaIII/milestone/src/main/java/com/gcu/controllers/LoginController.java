package com.gcu.controllers;

import com.gcu.models.LoginModel;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String display(Model model) {
        // Set model attributes
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());

        // Return the view name
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        // check for validation errors
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("title", "Login Form");
    		return "login";
    	}

        // Return the view name
        return "orders";
    }
}

