package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.PostEntity;
import com.gcu.data.repository.PostRepository;
import com.gcu.model.PostModel;

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
    public PostEntity getPostById(int id)
     {
        Optional<PostEntity> post = postRepository.findById(id); 

        if(post.isPresent())
        {
            return post.get();
        }

        throw new RuntimeException("Returned post was not correct for " + id);
        
    }
}