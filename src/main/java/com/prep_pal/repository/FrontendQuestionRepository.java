package com.prep_pal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prep_pal.model.FrontendQuestion;

@Repository 
public interface FrontendQuestionRepository extends MongoRepository<FrontendQuestion, String> {

}
