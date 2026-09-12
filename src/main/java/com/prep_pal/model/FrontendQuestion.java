package com.prep_pal.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.prep_pal.constants.QuestionDifficulty;

import lombok.NoArgsConstructor;

@Document(collection = "frontend_questions")
@NoArgsConstructor 
public class FrontendQuestion extends BaseQuestionSchema {

    public FrontendQuestion( String name, String userId, String link, QuestionDifficulty difficulty, int rating,
            boolean completed, boolean revision, ArrayList<String> companies, ArrayList<String> questionCategory,
            String notes, ArrayList<String> relatedQuestions, String createdAt) {
        super(null,  userId,name, link, difficulty, rating, completed, revision, companies, questionCategory, notes,
                relatedQuestions, createdAt);
    }

}