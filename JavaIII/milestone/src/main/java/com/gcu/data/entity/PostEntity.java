package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gcu.model.PostModel;

@Table("POSTS")
public class PostEntity {

    public PostEntity()
    {

    }
    
    public PostEntity(String imageUrl, String title, String description, String date, int userId) 
    {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
    }

    public PostEntity(PostModel post)
    {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId()
    {
        return this.id;
    }

}
