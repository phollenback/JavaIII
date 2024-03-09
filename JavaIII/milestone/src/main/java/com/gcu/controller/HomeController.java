package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.gcu.business.LoginService;
import com.gcu.business.RegistrationService;
import com.gcu.business.PostServiceInterface;
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
    @Autowired
    private LoginService ls;
    @Autowired
    private RegistrationService rs;
    @Autowired
    private PostServiceInterface service;

    /**
     * Displays the home page with a list of post models.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the home page
     */
    @GetMapping("/")
    public String showHomePage(Model model) {

        List<PostModel> posts = service.getPosts();
        model.addAttribute("posts", posts);
        return "home";
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

        // Utilize the Login Service to check for user existence and login
        if(ls.checkUserExistence(loginModel))
            return "redirect:/";
            
        return "login";
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
        model.addAttribute("signUpModel", new SignUpModel(null, null, null, null, null, null));
        return "signup";
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
        // check for validation errors 
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Sign Up Here!");
            return "signup";
        }

        // Utilize the Registration Service to initialize the user
        switch(rs.initializeUser(signUpModel))
        {
            case 1:             // successful
                return "redirect:/";
            case -1:            // same username
                model.addAttribute("title", "Username already taken!");
                return "signup";
            case -2:            // same email
                model.addAttribute("title", "Email already taken!");
                return "signup";
            case -3:            // same number
                model.addAttribute("title", "Phone Number already taken!");
                return "signup";
        }
            
            
        return "signup";
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


    /**
     * Displays the page for creating a new post.
     * @param model the model to be populated with attributes
     * @return the name of the view template for creating a post
     */
    @GetMapping("/create")
    public String showCreatePostPage(Model model) 
    {
        model.addAttribute("title", "Create Post Here!");
        model.addAttribute("postModel", new PostModel(null, null, null, null));
        return "createPost";
    }


    /**
     * Processes the creation of a new post.
     * @param postModel      the post model containing the new post's data
     * @param bindingResult  the binding result for validation errors
     * @param model          the model to be populated with attributes
     * @return the view template to redirect to, either the createPost template if there are errors or the home page
     */
    @PostMapping("/doCreatePost")
    public String doCreatePost(@Valid PostModel postModel, BindingResult bindingResult, Model model) 
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Create Post Here!");
            return "createPost";
        }

        // Save the new post
        service.savePost(postModel);

        // Get all posts including the newly added one
        List<PostModel> posts = service.getPosts();
        model.addAttribute("posts", posts);


        return "redirect:/";
    }

}   

