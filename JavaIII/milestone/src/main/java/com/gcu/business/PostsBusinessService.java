package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.PostModel;

/**
 * A service class for managing posts.
 */
@Service
public class PostsBusinessService implements PostServiceInterface
{

    private List<PostModel> posts = new ArrayList<>();
    
    @Autowired
    private DataAccessInterface<PostModel> service;

    /**
     * Retrieves the list of all posts.
     * @return the list of posts
     */
    @Override
    public List<PostModel> getPosts()
    {
        return service.findAll();
    }


    /**
     * Saves a new post.
     * @param newPost the new post to save
     * @return true if the post is saved successfully, false otherwise
     */
    @Override
    public boolean savePost(PostModel newPost) 
    {
        return service.create(newPost);
    }



}