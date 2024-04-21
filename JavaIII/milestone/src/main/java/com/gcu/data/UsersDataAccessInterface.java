package com.gcu.data;

/**
 * Interface for accessing user data.
 *
 * @param <T> The type of the entity being accessed.
 */
public interface UsersDataAccessInterface<T> {
	/**
	 * Finds a user by their username.
	 *
	 * @param username The username of the user to find.
	 * @return The object corresponding to the given username, or null if not found.
	 */
	T findByUsername(String username);
}
