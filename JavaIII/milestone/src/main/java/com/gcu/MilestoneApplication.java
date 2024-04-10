package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The main class to launch the Spring Boot application.
 */
@SpringBootApplication
public class MilestoneApplication {
	/**
     * The main method that starts the Spring Boot application.
     *
     * @param args Command line arguments passed to the application
     */
	public static void main(String[] args) {

		String plainTextPassword = "pass";
		String encodedPassword = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println("Encoded password: " + encodedPassword);
		
		
		SpringApplication.run(MilestoneApplication.class, args);
	}

}
