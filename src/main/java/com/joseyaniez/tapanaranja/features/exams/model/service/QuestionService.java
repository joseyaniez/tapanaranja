
package com.joseyaniez.tapanaranja.features.exams.model.service;

import java.util.List;

import com.joseyaniez.tapanaranja.features.exams.model.dto.request.QuestionRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.QuestionResponse;

/**
 * QuestionService
 */
public interface QuestionService {
    List<QuestionResponse> getQuestionsByCourse(Long courseId, int size);
    QuestionResponse getQuestionById(Long id);
    QuestionResponse createQuestion(QuestionRequest questionRequest);
    QuestionResponse updateQuestion(QuestionRequest questionRequest);
    void deleteQuestion(Long id);
}
