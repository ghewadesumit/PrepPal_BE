package com.prep_pal.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import com.prep_pal.constants.QuestionDifficulty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;


@Data
@Getter                 
@Setter                 
@NoArgsConstructor     
@AllArgsConstructor 
public class BaseQuestionSchema {

    @Id
    private String id;

    private String userId;
    
    private String name;

    private String link;

    private QuestionDifficulty difficulty;

    private int rating;

    private boolean completed;

    private boolean revision;

    private ArrayList<String> companies;

    private ArrayList<String> questionCategory;

    private String notes;

    private ArrayList<String> relatedQuestions;

    private String createdAt;

}
