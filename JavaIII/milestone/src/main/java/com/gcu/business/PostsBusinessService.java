package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.PostsDataService;
import com.gcu.data.entity.PostEntity;
import com.gcu.model.PostModel;

/**
 * A service class for managing posts.
 */
@Service
public class PostsBusinessService implements PostServiceInterface
{    
    @Autowired
	private PostsDataService service;

    /**
     * Retrieves the list of all posts.
     *
     * @return the list of posts
     */
    @Override
    public List<PostModel> getPosts() {
        List<PostEntity> postEntities = service.findAll();

        List<PostModel> postsDomain = new ArrayList<>();
        for (PostEntity entity : postEntities) {
            PostModel postModel = new PostModel(entity.getImageUrl(), entity.getTitle(), entity.getDescription(), entity.getDate(), entity.getUserId());
            postModel.setId(entity.getId()); // Set the ID in the PostModel
            postsDomain.add(postModel);
        }
        return postsDomain;
    }

    /**
     * creates a new post.
     *
     * @param newPost the new post to create
     * @return true if the post is created successfully, false otherwise
     */
    @Override
    public boolean createPost(PostModel newPost) {
        PostEntity entity = new PostEntity(newPost.getImageUrl(), newPost.getTitle(), newPost.getDescription(), newPost.getDate(), newPost.getUserId());
        return service.create(entity);
    }

    /**
     * updates a post
     *
     * @param post the post to update
     * @return true if the post is saved successfully, false otherwise
     */
    @Override
    public boolean updatePost(PostModel post, int id) {
        PostEntity entity = service.findById(id);
        entity.setImageUrl(post.getImageUrl());
        entity.setTitle(post.getTitle());
        entity.setDescription(post.getDescription());
        return service.update(entity);
    }   

    /**
     * get post by its id
     * 
     * @param id post id
     * @return the post correlating with the id
     */
    @Override
    public PostModel getPostById(int id) 
    {
        PostEntity entity = service.findById(id);
        if (entity != null) {
            PostModel model = new PostModel(entity.getImageUrl(), entity.getTitle(), entity.getDescription(), entity.getDate(), entity.getUserId());
            model.setId(entity.getId());
            
            return model;
        }
        return null;
    }

    /**
     * Deletes a post based on the provided ID.
     *
     * @param id the ID of the post to be deleted
     * @return true if the post was successfully deleted, false otherwise
     */
    @Override
    public boolean deletePost(int id)
    {
        return service.delete(id);
    }



    
    /**
     * Retrieves a list of posts for a given user ID.
     *
     * @param userId The ID of the user whose posts are to be retrieved.
     * @return A list of {@link PostModel} objects representing the posts of the user.
     */
    @Override
    public List<PostModel> getPostsByUserId(int userId) 
    {
        List<PostEntity> postEntities = service.findByUserId(userId);
        List<PostModel> postsDomain = new ArrayList<>();
        for (PostEntity entity : postEntities) {
            PostModel postModel = new PostModel(entity.getImageUrl(), entity.getTitle(), entity.getDescription(), entity.getDate(), entity.getUserId());
            postModel.setId(entity.getId()); // Set the ID in the PostModel
            postsDomain.add(postModel);
        }
        return postsDomain;
    }
}