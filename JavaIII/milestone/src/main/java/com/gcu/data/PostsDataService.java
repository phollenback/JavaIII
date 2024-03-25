package com.gcu.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.PostEntity;
import com.gcu.data.repository.PostRepository;

@Service
public class PostsDataService implements DataAccessInterface<PostEntity> {

    @Autowired
    private PostRepository postRepository;

    public PostsDataService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostEntity> findAll() {
        List<PostEntity> posts = new ArrayList<>();
        try {
            Iterable<PostEntity> ordersIterable = postRepository.findAll();
            posts = new ArrayList<>();
            ordersIterable.forEach(posts::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public boolean create(PostEntity post) 
    {

        // TODO -- Get user state so we can set the id accordingly
        post.setUserId(1);

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        post.setDate(formattedDate);
        try {
            this.postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public PostEntity findById(int id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(PostEntity post) {
        try {
            this.postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(PostEntity post) {
        try {
            this.postRepository.delete(post);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}


