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
    public boolean updatePost(PostModel post) {
        PostEntity entity = new PostEntity(post.getImageUrl(), post.getTitle(), post.getDescription(), post.getDate(), post.getUserId());
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



    @Override
    public boolean deletePost(int id)
    {
        return service.delete(id);
    }
}