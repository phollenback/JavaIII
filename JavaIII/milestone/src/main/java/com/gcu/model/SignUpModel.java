package com.gcu.model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Represents a data model for sign-up information.
 */
public class SignUpModel
 {
    /**
     * Constructs a new SignUpModel with the specified details.
     *
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param email the email address of the user
     * @param phoneNumber the phone number of the user
     * @param username the username chosen by the user
     * @param password the password chosen by the user
     */
    public SignUpModel(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    /**
     * First name of the user.
     * Annotated with @NotNull to specify that the field cannot be null.
     * Annotated with @Size to specify the minimum and maximum size of the string.
     */
    @NotNull(message = "First Name is Required")
    @Size(min = 1, max = 32, message = "First Name must be between 1 and 32 characters")
    private String firstName = "";

    /**
     * Last name of the user.
     * Annotated with @NotNull to specify that the field cannot be null.
     * Annotated with @Size to specify the minimum and maximum size of the string.
     */
    @NotNull(message = "Last Name is Required")
    @Size(min = 1, max = 32, message = "Last Name must be between 1 and 32 characters")
    private String lastName = "";

    /**
     * Email address of the user.
     * Annotated with @NotNull to specify that the field cannot be null.
     * Annotated with @Size to specify the minimum and maximum size of the string.
     */
    @NotNull(message = "Email is Required")
    @Size(min = 1, max = 32, message = "Email must be between 1 and 32 characters")
    private String email = "";

    /**
     * Phone number of the user.
     * Annotated with @NotNull to specify that the field cannot be null.
     * Annotated with @Size to specify the minimum and maximum size of the string.
     */
    @NotNull(message = "Phone Number is Required")
    @Size(min = 1, max = 32, message = "Phone Number must be between 1 and 32 characters")
    private String phoneNumber = "";

    /**
     * Username chosen by the user.
     * Annotated with @NotNull to specify that the field cannot be null.
     * Annotated with @Size to specify the minimum and maximum size of the string.
     */
    @NotNull(message = "Username is Required")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
    private String username = "";

    /**
     * Password chosen by the user.
     * Annotated with @NotNull to specify that the field cannot be null.
     * Annotated with @Size to specify the minimum and maximum size of the string.
     */
    @NotNull(message = "Password is Required")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password = "";

    /**
     * Gets the first name of the user.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the user.
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the user.
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the username chosen by the user.
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username chosen by the user.
     * @param userName The username to set.
     */
    public void setUsername(String userName) {
        this.username = userName;
    }

    /**
     * Gets the password chosen by the user.
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password chosen by the user.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

