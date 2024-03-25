package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.PostsDataService;
import com.gcu.data.entity.PostEntity;
import com.gcu.model.PostModel;

/**
 * A service class for managing posts.
 */
@Service
public class PostsBusinessService implements PostServiceInterface
{

    private List<PostModel> posts = new ArrayList<>();
    
    @Autowired
	private PostsDataService service;

    /**
     * Retrieves the list of all posts.
     * @return the list of posts
     */
    @Override
	public List<PostModel> getPosts() {
		List<PostEntity> postEntities = service.findAll();
		
		
		List<PostModel> ordersDomain = new ArrayList<PostModel>();
		for (PostEntity entity : postEntities)
		{
			ordersDomain.add(new PostModel(entity.getImageUrl(), entity.getTitle(), entity.getDescription(), entity.getDate(), entity.getUserId()));
		}
		
		
		return ordersDomain;
	}


    /**
     * Saves a new post.
     * @param newPost the new post to save
     * @return true if the post is saved successfully, false otherwise
     */
    @Override
    public boolean savePost(PostModel newPost) {
        PostEntity entity = new PostEntity(newPost.getImageUrl(), newPost.getTitle(), newPost.getDescription(), newPost.getDate(), newPost.getUserId());
        return service.create(entity);

    }


}