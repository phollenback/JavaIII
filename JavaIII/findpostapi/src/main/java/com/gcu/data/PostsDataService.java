package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.PostEntity;
import com.gcu.data.repository.PostRepository;

/**
 * A service class for managing post data that implements our data service
 * interface
 */
@Service
public class PostsDataService {

    @Autowired
    private PostRepository postRepository;

    /**
     * Constructs a new PostsDataService with the given PostRepository.
     * 
     * @param postRepository The repository for posts.
     */
    public PostsDataService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Retrieves one posts from the database.
     * 
     * @return A list of all posts.
     */
    public PostEntity findById(Long id)
     {
        int intId = id.intValue();

        // grab by id
        PostEntity returnThis = new PostEntity(postRepository.getPostById(intId));
        
        return returnThis;
    }
}