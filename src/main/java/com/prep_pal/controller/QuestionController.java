package com.prep_pal.controller;

import java.time.Instant;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prep_pal.model.BackendQuestion;
import com.prep_pal.model.FrontendQuestion;
import com.prep_pal.repository.BackendQuestionRepository;
import com.prep_pal.repository.FrontendQuestionRepository;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

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
    public BackendQuestion addQuestion(@RequestBody BackendQuestion question, @AuthenticationPrincipal OAuth2User principal) {

        String googleId = principal.getAttribute("sub");

        question.setUserId(googleId);
        question.setId(null);
        question.setCreatedAt(Instant.now().toString());
        return backendQuestionRepository.save(question);
    }
    @PostMapping("/frontend")
    public FrontendQuestion addQuestion(@RequestBody FrontendQuestion question, @AuthenticationPrincipal OAuth2User principal) {
        String googleId = principal.getAttribute("sub");

        question.setUserId(googleId);
        question.setId(null);
        question.setCreatedAt(Instant.now().toString());
        System.out.println("Received FrontendQuestion: " + question);
        return frontendQuestionRepository.save(question);
    }

}
