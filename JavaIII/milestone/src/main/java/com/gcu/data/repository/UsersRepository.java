package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserEntity;

/**
 * Repository interface for managing UserEntity objects in the database.
 */
public interface UsersRepository extends CrudRepository<UserEntity, Integer> {

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to find.
     * @return The UserEntity object corresponding to the given username, or null if
     *         not found.
     */
    UserEntity findByUsername(String username);
}
