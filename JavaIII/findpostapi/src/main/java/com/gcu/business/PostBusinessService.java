package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.PostModel;

@Service
public class PostBusinessService 
{
    @Autowired
    private PostBusinessService postService;

    public PostModel getPostById(Long id)
    {
        // get post entity from layer below
        PostModel convert = postService.getPostById(id);
        // convert to PostModel
        PostModel returnThis = new PostModel(convert.getImageUrl(), convert.getTitle(), convert.getDescription(), convert.getDate(), convert.getUserId());
        // set id
        returnThis.setId(convert.getId());
        
        return returnThis;
    }
}