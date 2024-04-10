package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public class UserEntity {

    @Id
    @Column("id")
    int id;

    @Column("first_name")
    String firstName;

    @Column("last_name")
    String lastName;

    @Column("email")
    String email;

    @Column("phone_number")
    String phoneNumber;

    @Column("username")
    String username;

    @Column("password")
    String password;

    /**
     * Default constructor.
     */
    public UserEntity() {

    }

    /**
     * Constructs a UserEntity with the specified attributes.
     * @param first 
     * @param last 
     * @param email 
     * @param phone 
     * @param username
     * @param password
     */
    public UserEntity(String first, String last, String email, String phone, String username, String password) {
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.phoneNumber = phone;
        this.username = username;
        this.password = password;
    }

    // Getter and setter methods for the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
