package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.PostEntity;

/**
 * Repository interface for managing PostEntity objects in the database.
 */
public interface PostRepository extends CrudRepository<PostEntity, Integer> {

	
	/**
     * Retrieves a list of posts by the user ID.
     *
     * @param userId the ID of the user
     * @return a list of PostEntity objects associated with the user ID
     */
    List<PostEntity> findByUserId(int userId);

}
