package com.rparenato.cursoSpringBootMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rparenato.cursoSpringBootMongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
