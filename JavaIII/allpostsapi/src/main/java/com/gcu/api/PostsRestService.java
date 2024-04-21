package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.PostsBusinessService;
import com.gcu.model.PostModel;

/**
 * REST controller for managing posts.
 */
@RestController
@RequestMapping("/service")
public class PostsRestService {
	@Autowired
	PostsBusinessService service;

	/**
	 * Retrieves all posts.
	 *
	 * @return a ResponseEntity containing a list of posts if found, or an
	 *         appropriate HTTP status code if not
	 */
	@GetMapping(path = "/posts")
	public ResponseEntity<?> getPosts() {
		try {
			List<PostModel> posts = service.getPosts();
			if (posts.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(posts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
