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

@RestController
@RequestMapping("/service")
public class PostsRestService {
    @Autowired
	private PostServiceInterface service;
	
	@GetMapping(value="/posts", produces={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public List<PostModel> getPosts()
	{
		return service.getPosts();
	}
	
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
