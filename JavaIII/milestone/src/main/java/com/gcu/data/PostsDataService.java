package com.gcu.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.PostModel;

/**
 * This class provides data access methods for managing posts in a database.
 */
@Service
public class PostsDataService implements DataAccessInterface<PostModel> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * Constructor to set the data source and initialize the JDBC template.
     * 
     * @param dataSource the data source to be used for database access
     */
    public PostsDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * Retrieves all posts from the database.
     * 
     * @return a list of all posts in the database
     */
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
    
    /**
     * Retrieves one post from the database.
     * 
     * @param id the id of the user selected
     * @return the post with the specified ID, or null if not found
     */
    @Override
    public PostModel findById(int id) {
        // Implement logic to find post by id from the database
        return null;
    }

    /**
     * Creates a new post in the database
     * 
     * @param post the post to create
     * @return true if the user was created successfully, false otherwise
     */
    @Override
    public boolean create(PostModel post) 
    {
        // Get today's date in the format "Month name, number, year"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);

        String sql = "INSERT INTO POSTS (image_url, title, description, date, Users_id) VALUES (?, ?, ?, ?, 1)";
        int insertedRows = jdbcTemplateObject.update(sql, post.getImageUrl(), post.getTitle(), post.getDescription(), formattedDate);
        return insertedRows > 0;
    }

    /**
     * Updates a new post in the database.
     *
     * @param post the post to update
     * @return true if the post was updated successfully, false otherwise
     */
    @Override
    public boolean update(PostModel post) {
        // Implement logic to update a post in the database
        // Example:
        String sql = "";
        int updatedRows = jdbcTemplateObject.update(sql, "");
        return updatedRows > 0;
    }

    /**
     * Deletes an existing post in the database.
     * 
     * @param post the post to delete
     * @return true if the post was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(PostModel post) {
        // Implement logic to delete a post from the database
        return false;
    }
}
