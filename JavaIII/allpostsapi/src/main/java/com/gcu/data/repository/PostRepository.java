package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.PostEntity;

/**
 * Repository interface for managing PostEntity objects in the database.
 */
public interface PostRepository extends CrudRepository<PostEntity, Integer> {

}
