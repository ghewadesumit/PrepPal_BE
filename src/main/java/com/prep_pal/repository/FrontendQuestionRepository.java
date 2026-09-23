package com.prep_pal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prep_pal.model.FrontendQuestion;

@Repository 
public interface FrontendQuestionRepository extends MongoRepository<FrontendQuestion, String> {
    List<FrontendQuestion> findByUserId(String userId);
}
