package com.gcu.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class PostsDataService implements DataAccessInterface<PostEntity> {

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
     * Retrieves all posts from the database.
     * 
     * @return A list of all posts.
     */
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

    /**
     * Creates a new post.
     * 
     * @param post The post to create.
     * @return True if the post was successfully created, false otherwise.
     */
    @Override
    public boolean create(PostEntity post) {

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

    /**
     * Finds a post by its ID.
     * 
     * @param id The ID of the post to find.
     * @return The found post, or null if not found.
     */
    @Override
    public PostEntity findById(int id) {
        return this.postRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing post.
     * 
     * @param post The post to update.
     * @return True if the post was successfully updated, false otherwise.
     */
    @Override
    public boolean update(PostEntity post) {
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

    /**
     * Deletes a post by its ID.
     * 
     * @param id The ID of the post to delete.
     * @return True if the post was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(int id) {
        try {
            this.postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
