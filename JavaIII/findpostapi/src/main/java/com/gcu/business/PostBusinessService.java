package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.PostsDataService;
import com.gcu.data.entity.PostEntity;
import com.gcu.model.PostModel;

@Service
public class PostBusinessService 
{
    @Autowired
    private PostsDataService postService;

    public PostModel getPostById(int id)
    {
        // get post entity from layer below
        PostEntity convert = postService.getPostById(id);
        // convert to PostModel
        PostModel returnThis = new PostModel(convert.getId(),convert.getImageUrl(), convert.getTitle(), convert.getDescription(), convert.getDate(), convert.getUserId());
        // set id
        returnThis.setId(convert.getId());
        
        return returnThis;
    }
}