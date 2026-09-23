package com.prep_pal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prep_pal.model.BackendQuestion;

public interface BackendQuestionRepository extends MongoRepository<BackendQuestion, String> {
    List<BackendQuestion> findByUserId(String userId);
}
