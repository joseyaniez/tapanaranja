
package com.joseyaniez.tapanaranja.features.exams.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.exams.model.dto.request.QuestionRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.QuestionResponse;
import com.joseyaniez.tapanaranja.features.exams.service.QuestionService;
import com.joseyaniez.tapanaranja.features.exams.service.impl.QuestionServiceImpl;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;


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

    @PostMapping
    public ApiResponse<QuestionResponse> create(@RequestBody @Valid QuestionRequest questionRequest){
        QuestionResponse resp = questionService.createQuestion(questionRequest);
        return new ApiResponse<QuestionResponse>(true, resp, "Question creado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ApiResponse<QuestionResponse> update(@PathVariable Long id, @RequestBody @Valid QuestionRequest questionRequest){
        QuestionResponse resp = questionService.updateQuestion(id, questionRequest);
        return new ApiResponse<QuestionResponse>(true, resp, "Question actualizado");
    }

    @GetMapping("/section/{id}")
    public ApiResponse<List<QuestionResponse>> getForSection(@PathVariable Long id, @RequestParam(defaultValue = "10") int size){
        List<QuestionResponse> questions = questionService.getQuestionsBySection(id, size);
        return new ApiResponse<List<QuestionResponse>>(true, questions, null);
    }

    @GetMapping("/chapter/{id}")
    public ApiResponse<List<QuestionResponse>> getForChapter(@PathVariable Long id, @RequestParam(defaultValue = "10") int size){
        List<QuestionResponse> questions = questionService.getQuestionsByChapter(id, size);
        return new ApiResponse<List<QuestionResponse>>(true, questions, null);
    }

    @GetMapping("/course/{id}")
    public ApiResponse<List<QuestionResponse>> getForCourse(@PathVariable Long id, @RequestParam(defaultValue = "10") int size){
        List<QuestionResponse> questions = questionService.getQuestionsByCourse(id, size);
        return new ApiResponse<List<QuestionResponse>>(true, questions, null);
    }
    
}
