package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.PostModel;

/**
 * A service class for managing posts.
 */
@Service
public class PostsBusinessService implements PostServiceInterface
{

    private List<PostModel> posts = new ArrayList<>();


    /**
     * Initializes the list of posts with some default values.
     */
    public PostsBusinessService() {
        // Initialize the list of posts
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 1", "this is filler text about the post.", "January 1, 2023"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 2", "this is filler text about the post.", "January 2, 2023"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 3", "this is filler text about the post.", "January 3, 2023"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 4", "this is filler text about the post.", "January 4, 2024"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 5", "this is filler text about the post.", "January 5, 2025"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 6", "this is filler text about the post.", "January 6, 2024"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 7", "this is filler text about the post.", "January 7, 2024"));
        posts.add(new PostModel("https://via.placeholder.com/300", "POST 8", "this is filler text about the post.", "January 8, 2024"));
    }


    /**
     * Retrieves the list of all posts.
     * @return the list of posts
     */
    @Override
    public List<PostModel> getPosts()
     {
        return posts;
    }


    /**
     * Saves a new post.
     * @param newPost the new post to save
     * @return the updated list of posts
     */
    @Override
    public List<PostModel> savePost(PostModel newPost)
    {
        List<PostModel> posts = getPosts();

        posts.add(newPost);

        return posts;
    }


}