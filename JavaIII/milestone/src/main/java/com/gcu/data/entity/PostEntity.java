package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gcu.model.PostModel;

/**
 * Represents a post entity, mapping to the "POSTS" table in the database.
 */
@Table("POSTS")
public class PostEntity {

    /**
     * Default constructor.
     */
    public PostEntity() {

    }

    /**
     * Constructs a PostEntity with the specified attributes.
     * @param imageUrl The URL of the post's image.
     * @param title The title of the post.
     * @param description The description of the post.
     * @param date The date of the post.
     * @param userId The ID of the user who created the post.
     */
    public PostEntity(String imageUrl, String title, String description, String date, int userId) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
    }

    /**
     * Constructs a PostEntity from a PostModel object.
     * @param post The PostModel object to construct the entity from.
     */
    public PostEntity(PostModel post) {
        this.imageUrl = post.getImageUrl();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.date = post.getDate();
        this.userId = post.getUserId();
    }

    @Id
    int id;

    @Column("image_url")
    String imageUrl;

    @Column("title")
    String title;

    @Column("description")
    String description;

    @Column("date")
    String date;

    @Column("Users_id")
    int userId;

    /**
     * Retrieves the URL of the post's image.
     * @return The URL of the post's image.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL of the post's image.
     * @param imageUrl The URL of the post's image to set.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Retrieves the title of the post.
     * @return The title of the post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the post.
     * @param title The title of the post to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description of the post.
     * @return The description of the post.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the post.
     * @param description The description of the post to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the date of the post.
     * @return The date of the post.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the post.
     * @param date The date of the post to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Retrieves the ID of the user who created the post.
     * @return The ID of the user who created the post.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who created the post.
     * @param userId The ID of the user who created the post to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the ID of the post.
     * @return The ID of the post.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the ID of the post.
     * @param userId The ID of the post to set.
     */
    public void setId(int id) {
        this.id = id;
    }


}
