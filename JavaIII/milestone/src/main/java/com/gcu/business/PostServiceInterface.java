package com.gcu.business;

import java.util.List;

import com.gcu.model.PostModel;


/**
 * An interface for managing posts.
 */
public interface PostServiceInterface 
{
    /**
     * Retrieves the list of all posts.
     * @return the list of posts
     */
    public List<PostModel> getPosts();

    /**
     * Saves a new post.
     * @param newModel the new post to save
     * @return the updated list of posts
     */
    public boolean createPost(PostModel newModel);

    /**
     * Updates a post.
     * @param model the post to update
     * @return the updated list of posts
     */
    public boolean updatePost(PostModel model);

    public PostModel getPostById(int id);

    public boolean deletePost(int id);
}
