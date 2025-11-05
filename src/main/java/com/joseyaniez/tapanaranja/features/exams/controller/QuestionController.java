
package com.joseyaniez.tapanaranja.features.exams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.QuestionResponse;
import com.joseyaniez.tapanaranja.features.exams.service.QuestionService;
import com.joseyaniez.tapanaranja.features.exams.service.impl.QuestionServiceImpl;

/**
 * QuestionController
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionServiceImpl questionServiceImpl){
        this.questionService = questionServiceImpl;
    }

    @GetMapping("/{id}")
    public ApiResponse<QuestionResponse> getById(@PathVariable Long id){
        QuestionResponse response = questionService.getQuestionById(id);
        return new ApiResponse<QuestionResponse>(true, response, null);
    }

    
}
