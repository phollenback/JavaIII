package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.PostModel;

@Service
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
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                posts.add(new PostModel(srs.getString("image_url"),
                        srs.getString("title"),
                        srs.getString("description"),
                        srs.getString("date")));
            }
        } catch (Exception e) {
            e.printStackTrace(); // For now, just print stack trace
        }
        return posts;
    }
    

    @Override
    public PostModel findById(int id) {
        // Implement logic to find post by id from the database
        return null;
    }

    @Override
    public boolean create(PostModel post) 
    {
        String sql = "INSERT INTO POSTS (image_url, title, description, date) VALUES (?, ?, ?, ?)";
        int insertedRows = jdbcTemplateObject.update(sql, post.getImageUrl(), post.getTitle(), post.getDescription(), post.getDate());
        return insertedRows > 0;
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
