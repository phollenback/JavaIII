package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.PostEntity;
import com.gcu.model.PostModel;

/**
 * Repository interface for managing PostEntity objects in the database.
 */
public interface PostRepository extends CrudRepository<PostEntity, Integer> {

    PostModel getPostById(int intId);

}
