package com.gcu.model;


/**
 * Represents a PostModel with imageUrl, title, description, date, and userId attributes.
 */
public class PostModel {
    private int id;
    private String imageUrl;
    private String title;
    private String description;
    private String date;
    private int userId;

    /**
     * Default constructor.
     */
    public PostModel() {
    }

    /**
     * Constructs a new PostModel with the specified imageUrl, title, description, date, and userId.
     *
     * @param imageUrl    The URL of the image associated with the post.
     * @param title       The title of the post.
     * @param description The description or content of the post.
     * @param date        The date when the post was created or published.
     * @param userId      The ID of the user who created the post.
     */
    public PostModel(String imageUrl, String title, String description, String date, int userId) {
        super();
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
    }

    /**
     * Retrieves the ID of the post.
     *
     * @return The ID of the post.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the post.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for other attributes...
    
    /**
     * Retrieves the URL of the image associated with the post.
     *
     * @return The imageUrl of the post.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL of the image associated with the post.
     *
     * @param imageUrl The URL to set.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Retrieves the title of the post.
     *
     * @return The title of the post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the post.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description or content of the post.
     *
     * @return The description of the post.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description or content of the post.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the date when the post was created or published.
     *
     * @return The date of the post.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date when the post was created or published.
     *
     * @param date The date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Retrieves the ID of the user who created the post.
     *
     * @return The userId of the post creator.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who created the post.
     *
     * @param userId The userId to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}

