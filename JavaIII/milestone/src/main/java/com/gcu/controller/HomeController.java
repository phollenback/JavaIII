package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;
import jakarta.servlet.http.HttpServletRequest;

// import com.gcu.business.LoginService;
import com.gcu.business.RegistrationService;
import com.gcu.business.PostServiceInterface;
// import com.gcu.model.LoginModel;
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
    private RegistrationService rs;

    @Autowired
    private PostServiceInterface service;

    @Autowired
    private UsersDataService usersDataService;

    /**
     * Displays the home page with a list of post models.
     * @param model the Spring MVC model for rendering the view
     * @return the view name for the home page
     */
    @GetMapping("/")
    public String showHomePage(Model model, HttpServletRequest request) {
    

        try 
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            UserEntity user = usersDataService.findByUsername(username);

            // Store user details in session
            request.getSession().setAttribute("user", user);

            // Now you can get the user ID
            int userId = user.getId();

            // Store user ID in session
            request.getSession().setAttribute("userId", userId);
        } catch (Exception e) 
        {
            // Handle the exception, e.g., log it or show a user-friendly error message
            e.printStackTrace(); // Example: print the stack trace
        }
    
        List<PostModel> posts = service.getPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }
    
    /**
     * Retrieves a list of posts from a service and adds them to the model for display.
     *
     * @param model the model to which post data and title will be added
     * @return the name of the view to be rendered, in this case, "posts"
     */
    @GetMapping("/getposts")
	public String getPosts(Model model)
	{
        // get all posts
		List<PostModel> posts = service.getPosts();
        // pass posts in key value
        model.addAttribute("title", "List of Posts");
		model.addAttribute("posts", posts);
        // return posts
		return "posts";
	}

    /**
     * Displays the 
     * @param model Post Model for returned posts
     * @return posts html page
     */
    @GetMapping("/findpost/{id}")
    public String getPost(@PathVariable("id") int id, Model model)
    {
        // get model by id
        PostModel post = service.getPostById(id);

        // pass post in key value pairs
        model.addAttribute("title", "List of Posts");
		model.addAttribute("posts", post);
        // return
		return "posts";
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
        int initializationResult = rs.initializeUser(signUpModel);
        switch(initializationResult)
        {
            case 1:             // successful
                // Authenticate the user after successful sign-up
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
            default:
                model.addAttribute("title", "Error during sign-up!");
                return "signup";
        }        
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
    public String showCreatePostPage(Model model, HttpServletRequest request) 
    {
        
        model.addAttribute("title", "Create Post Here!");

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        model.addAttribute("postModel", new PostModel("", "", "", "", userId));
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
            System.out.println("Validation errors:");
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + ": " + error.getDefaultMessage());
            }
            model.addAttribute("title", "Create Post Here!");
            return "createPost";
        }        
        // Save the new post
        service.createPost(postModel);

        // Get all posts including the newly added one
        List<PostModel> posts = service.getPosts();
        
        model.addAttribute("posts", posts);

        return "redirect:/";
    }


    /**
     * Retrieves details of a specific post by its ID.
     *
     * @param id    The ID of the post to retrieve details for.
     * @param model The model to which post details will be added.
     * @return The view name for displaying post details.
     */
    @GetMapping("/post/{id}")
    public String showPostDetails(@PathVariable int id, Model model) {
        // Logic to retrieve the post details by id
        PostModel post = service.getPostById(id);
        model.addAttribute("postModel", post);
        return "postDetails";
    }


    /**
     * Retrieves all of the posts from the 
     *
     * @param id    The ID of the user
     * @param model The model to which post details will be added.
     * @return The view name for displaying post details.
     */
    @GetMapping("/account")
    public String showAccount(Model model, HttpServletRequest request) {

        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        String name = user.getUsername();
        int userId = user.getId();

        // Logic to retrieve posts by userId
        List<PostModel> posts = service.getPostsByUserId(userId);
        
        // Add posts to the model
        model.addAttribute("posts", posts);
        model.addAttribute("name", name);
        
        return "account";
    }



    /**
     * Deletes a post based on its ID.
     *
     * @param id The ID of the post to delete.
     * @return Redirects to the home page after deletion.
     */
    @PostMapping("/post/delete/{id}")
        public String deletePost(@PathVariable int id) {
        service.deletePost(id);
        return "redirect:/";
    }

    /**
     * Prepares the update form for a specific post.
     *
     * @param id    The ID of the post to update.
     * @param model The model to which post details will be updated.
     * @return The view name for updating the post.
     */
    @PostMapping("/post/update/{id}")
    public String updatePost(@PathVariable int id, Model model) {
        PostModel post = service.getPostById(id);
        model.addAttribute("postModel", post);
        return "updatePost";
    }

    /**
     * Performs the update operation for a post.
     *
     * @param postModel     The updated post model.
     * @param bindingResult The result of the validation.
     * @param model         The model to which attributes will be updated.
     * @return Redirects to the home page after updating the post.
     */
    @PostMapping("/post/update/doUpdate/{id}")
    public String doUpdatePost(@PathVariable int id, @Valid PostModel postModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors:");
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + ": " + error.getDefaultMessage());
            }
            model.addAttribute("title", "Update Post Here!");
            return "updatePost";
        }

        // updates post
        service.updatePost(postModel, id);

        // Get all posts including the updated one
        List<PostModel> posts = service.getPosts();

        model.addAttribute("posts", posts);

        return "redirect:/";
    }
}   

