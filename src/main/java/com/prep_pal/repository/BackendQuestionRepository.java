package com.prep_pal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prep_pal.model.BackendQuestion;

public interface BackendQuestionRepository extends MongoRepository<BackendQuestion, String> {

}
