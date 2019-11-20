package com.rparenato.cursoSpringBootMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rparenato.cursoSpringBootMongoDB.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
