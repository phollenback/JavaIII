package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.PostServiceInterface;
import com.gcu.model.PostModel;


/**
 * Rest controller for managing posts.
 */
@RestController
@RequestMapping("/service")
public class PostsRestService {
    @Autowired
	private PostServiceInterface service;
	
	
    /**
     * Retrieves a list of all posts.
     *
     * @return A list of {@link PostModel} objects representing the posts.
     */
    @GetMapping(value="/posts", produces={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public List<PostModel> getPosts()
	{
		return service.getPosts();
	}
	
	
    /**
     * Retrieves a post by its ID.
     *
     * @param id The ID of the post to retrieve.
     * @return A {@link ResponseEntity} containing the {@link PostModel} object if found, or a NOT_FOUND status if not found.
     */
    @GetMapping("/getpost/{id}")
    public ResponseEntity<PostModel> getPosts(@PathVariable("id") int id) {
        try {
            PostModel post = service.getPostById(id);
            if (post == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
            } else {
            	return new ResponseEntity<>(post, HttpStatus.OK);             
            }
        } catch (Exception e) {
            // Catch any exception and return with HttpStatus.INTERNAL_SERVER_ERROR
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
