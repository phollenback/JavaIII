package com.gcu.model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class SignUpModel 
{
    @NotNull(message="First Name is Required")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String firstName = "";


    @NotNull(message="Last Name is Required")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String lastName = "";


    @NotNull(message="Email is Required")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String email = "";


    @NotNull(message="Phone Number is Required")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String phoneNumber = "";


    @NotNull(message="Username is Required")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username = "";

    
    @NotNull(message="Password is Required")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String password = "";
    
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
    public void setUsername(String userName) {
        this.username = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
