package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.PostModel;
import com.gcu.model.SignUpModel;

import jakarta.validation.Valid;

/**
 * Handles requests related to the home page, sign-up, login, and user sign-in.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Displays the home page with a list of post models.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the home page
     */
    @GetMapping("/")
    public String showHomePage(Model model) {

        List<PostModel> postModels = new ArrayList<>();

        // Populate the list with data (replace this with your actual data)
        PostModel post1 = new PostModel();
        post1.setImageUrl("https://via.placeholder.com/300");
        post1.setTitle("POST 1");
        post1.setDescription("this is filler text about the post.");
        post1.setDate("January 1, 2023");

        PostModel post2 = new PostModel();
        post2.setImageUrl("https://via.placeholder.com/300");
        post2.setTitle("POST 2");
        post2.setDescription("this is filler text about the post.");
        post2.setDate("January 2, 2023");

        PostModel post3 = new PostModel();
        post3.setImageUrl("https://via.placeholder.com/300");
        post3.setTitle("POST 3");
        post3.setDescription("this is filler text about the post.");
        post3.setDate("January 3, 2023");


        PostModel post4 = new PostModel();
        post4.setImageUrl("https://via.placeholder.com/300");
        post4.setTitle("POST 4");
        post4.setDescription("this is filler text about the post.");
        post4.setDate("January 4, 2024");

        PostModel post5 = new PostModel();
        post5.setImageUrl("https://via.placeholder.com/300");
        post5.setTitle("POST 5");
        post5.setDescription("this is filler text about the post.");
        post5.setDate("January 5, 2025");

        PostModel post6 = new PostModel();
        post6.setImageUrl("https://via.placeholder.com/300");
        post6.setTitle("POST 6");
        post6.setDescription("this is filler text about the post.");
        post6.setDate("January 6, 2024");

        PostModel post7 = new PostModel();
        post7.setImageUrl("https://via.placeholder.com/300");
        post7.setTitle("POST 7");
        post7.setDescription("this is filler text about the post.");
        post7.setDate("January 7, 2024");

        PostModel post8 = new PostModel();
        post8.setImageUrl("https://via.placeholder.com/300");
        post8.setTitle("POST 8");
        post8.setDescription("this is filler text about the post.");
        post8.setDate("January 8, 2024");

        // Add the PostModel instances to the list
        postModels.add(post1);
        postModels.add(post2);
        postModels.add(post3);
        postModels.add(post4);
        postModels.add(post5);
        postModels.add(post6);
        postModels.add(post7);
        postModels.add(post8);

        // Add the list to the model
        model.addAttribute("postModels", postModels);
        
        return "home";
    }

    
    /**
     * Displays the sign-up form view.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the sign-up page
     */
    @GetMapping("/signup")
    public String showSignUpPage(Model model) 
    {
        
        // Display Sign Up Form View
        model.addAttribute("title", "Sign Up Here!");
        model.addAttribute("signUpModel", new SignUpModel());
        return "signup";
    }


    /**
     * Displays the login form view.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the login page
     */
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Display Login Form View
        model.addAttribute("title", "Login Here!");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }


    /**
     * Handles the login form submission.
     * @param loginModel the model representing the login form data
     * @param bindingResult the Spring MVC binding result for validation
     * @param model the Spring MVC model for rendering the view
     * @return the view name for redirection after login
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        // check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Here!");
            return "login";
        }

        return "redirect:/";
    }
    /**
     * Handles the sign-up form submission.
     *
     * @param signUpModel   the model representing the sign-up form data
     * @param bindingResult the Spring MVC binding result for validation
     * @param model         the Spring MVC model for rendering the view
     * @return the view name for redirection after sign-up
     */
    @PostMapping("/doSignUp")
    public String doSignUp(@Valid SignUpModel signUpModel, BindingResult bindingResult, Model model) 
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Sign Up Here!");
            return "signup";
        }

        return "redirect:/";
    }

     /**
     * Displays the starter page for user sign-in.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the sign-in page
     */
    @GetMapping("/signIn")
    public String showStarterPage(Model model) {
        model.addAttribute("title", "Portfol.io");
        return "signIn";
    }
}

