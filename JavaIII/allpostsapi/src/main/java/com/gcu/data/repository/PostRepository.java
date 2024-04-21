package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Integer> 
{

}
