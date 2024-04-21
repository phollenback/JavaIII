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
public class PostsBusinessService
{    
    @Autowired
	private PostsDataService service;

    /**
     * Retrieves the list of all posts.
     *
     * @return the list of posts
     */
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
}