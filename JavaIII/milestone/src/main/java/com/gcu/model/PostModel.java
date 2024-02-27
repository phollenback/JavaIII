package com.gcu.model;


/**
 * Represents a post model with details such as image URL, title, description, and date.
 * This class is typically used to encapsulate data for displaying posts.
 */
public class PostModel {
    private String imageUrl;
    private String title;
    private String description;
    private String date;

    /**
     * Gets the URL of the post image.
     * @return the image URL of the post
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Gets the title of the post.
     * @return the title of the post
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description of the post.
     * @return the description of the post
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the date of the post.
     * @return the date of the post
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the image URL of the post.
     * @param imageUrl the image URL to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Sets the title of the post.
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the description of the post.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the date of the post.
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }



    public PostModel(String imageUrl, String title, String description, String date) {
		super();
		this.imageUrl = imageUrl;
		this.title = title;
		this.description = description;
		this.date = date;
	}
}
