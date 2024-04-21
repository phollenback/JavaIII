package main.java.com.gcu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.PostModel;

/**
 * REST controller for managing posts.
 */
@RestController
@RequestMapping("/service")
public class PostRestService {
	@Autowired
	PostsBusinessService service;

	/**
     * Retrieves a post by id.
     *
     * @param id the ID of the post to retrieve
     * @return a ResponseEntity containing the post if found, or an
     *         appropriate HTTP status code if not
     */
    @GetMapping(path = "/posts/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        try {
            PostModel post = service.findPostById(id);  // grab from lower layer
            if (post.isPresent()) {
                return new ResponseEntity<>(posts, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Returns a 404 status if the post is not found
            }
        } catch (Exception e) {
            // Log the exception and return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the post");
        }
    }

}