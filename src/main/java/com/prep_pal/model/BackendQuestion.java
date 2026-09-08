package com.prep_pal.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.prep_pal.constants.QuestionDifficulty;

import lombok.NoArgsConstructor;

@Document(collection = "backend_questions")
@NoArgsConstructor 
public class BackendQuestion extends BaseQuestionSchema {

    public BackendQuestion( String name, String link, QuestionDifficulty difficulty, int rating,
            boolean completed, boolean revision, ArrayList<String> companies, ArrayList<String> questionCategory,
            String notes, ArrayList<String> relatedQuestions, String createdAt) {
        super(null, name, link, difficulty, rating, completed, revision, companies, questionCategory, notes,
            relatedQuestions, createdAt);
    }

}
