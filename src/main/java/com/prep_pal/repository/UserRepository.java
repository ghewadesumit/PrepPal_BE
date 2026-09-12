package com.prep_pal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prep_pal.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserId(String userId);
}
