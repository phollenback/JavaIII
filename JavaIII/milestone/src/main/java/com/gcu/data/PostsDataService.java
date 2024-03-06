package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.PostModel;

public class PostsDataService implements DataAccessInterface<PostModel> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public PostsDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<PostModel> findAll() {
        String sql = "SELECT * FROM POSTS"; // Correct table name
        // Perform database query to fetch posts
        List<PostModel> posts = new ArrayList<>();
        // Populate posts list from database
        return posts;
    }

    @Override
    public PostModel findById(int id) {
        // Implement logic to find post by id from the database
        return null;
    }

    @Override
    public boolean create(PostModel post) {
        // Implement logic to create a post in the database
        return false;
    }

    @Override
    public boolean update(PostModel post) {
        // Implement logic to update a post in the database
        // Example:
        String sql = "";
        int updatedRows = jdbcTemplateObject.update(sql, "");
        return updatedRows > 0;
    }

    @Override
    public boolean delete(PostModel post) {
        // Implement logic to delete a post from the database
        return false;
    }
}
