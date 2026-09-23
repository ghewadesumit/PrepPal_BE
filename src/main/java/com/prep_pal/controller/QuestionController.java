package com.prep_pal.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prep_pal.model.BackendQuestion;
import com.prep_pal.model.FrontendQuestion;
import com.prep_pal.repository.BackendQuestionRepository;
import com.prep_pal.repository.FrontendQuestionRepository;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final BackendQuestionRepository backendQuestionRepository;
    private final FrontendQuestionRepository frontendQuestionRepository;

    public QuestionController(BackendQuestionRepository backendQuestionRepository, FrontendQuestionRepository frontendQuestionRepository) {
        this.backendQuestionRepository = backendQuestionRepository;
        this.frontendQuestionRepository = frontendQuestionRepository;
    }

    @PostMapping("/backend")
    public BackendQuestion addBackendQuestion(@RequestBody BackendQuestion question, @AuthenticationPrincipal OAuth2User principal) {

        String googleId = principal.getAttribute("sub");

        question.setUserId(googleId);
        question.setId(null);
        question.setCreatedAt(Instant.now().toString());
        
        return backendQuestionRepository.save(question);
    }
    
    @PostMapping("/frontend")
    public FrontendQuestion addFrontendQuestion(@RequestBody FrontendQuestion question, @AuthenticationPrincipal OAuth2User principal) {
        String googleId = principal.getAttribute("sub");

        question.setUserId(googleId);
        question.setId(null);
        question.setCreatedAt(Instant.now().toString());
        
        return frontendQuestionRepository.save(question);
    }

    @GetMapping("/backend")
    public List<BackendQuestion> getAllBackendQuestions(@AuthenticationPrincipal OAuth2User principal) {
        String googleId = principal.getAttribute("sub");
        return backendQuestionRepository.findByUserId(googleId);
    }

    @GetMapping("/frontend")
    public List<FrontendQuestion> getAllFrontendQuestions(@AuthenticationPrincipal OAuth2User principal) {

        String googleId = principal.getAttribute("sub");

         System.out.println("Fetching FrontendQuestions for user: " + googleId);
        return frontendQuestionRepository.findByUserId(googleId);
    }

}
