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
     * @param id id of the post
     * @return the updated list of posts
     */
    public boolean updatePost(PostModel model, int id);

    
	/**
	 * Retrieves a post by its ID.
	 *
	 * @param id the ID of the post to retrieve
	 * @return the post with the specified ID, or null if not found
	 */
    public PostModel getPostById(int id);

    
    /**
     * Deletes a post by its ID.
     *
     * @param id the ID of the post to delete
     * @return true if the deletion was successful, false otherwise
     */
    public boolean deletePost(int id);

    
    /**
     * Retrieves the list of posts belonging to a user with the given user ID.
     * 
     * @param userId the ID of the user
     * @return the list of posts belonging to the user
     */
    public List<PostModel> getPostsByUserId(int userId);
}
