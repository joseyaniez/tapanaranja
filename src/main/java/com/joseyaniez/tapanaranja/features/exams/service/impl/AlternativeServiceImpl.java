
package com.joseyaniez.tapanaranja.features.exams.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.exams.model.dto.request.AlternativeRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.AlternativeResponse;
import com.joseyaniez.tapanaranja.features.exams.model.entity.Alternative;
import com.joseyaniez.tapanaranja.features.exams.model.entity.Question;
import com.joseyaniez.tapanaranja.features.exams.repository.AlternativeRepository;
import com.joseyaniez.tapanaranja.features.exams.repository.QuestionRepository;
import com.joseyaniez.tapanaranja.features.exams.service.AlternativeService;

import lombok.RequiredArgsConstructor;

/**
 * AlternativeServiceImpl
 */
@Service
@RequiredArgsConstructor

public class AlternativeServiceImpl implements AlternativeService {

    private final AlternativeRepository alternativeRepository;
    private final QuestionRepository questionRepository;

    @Override
    public List<AlternativeResponse> getAlternativesbyCourse(Long questionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlternativesbyCourse'");
    }

    @Override
    public AlternativeResponse getAlternativeById(Long id) {
        Alternative alternative = alternativeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Alternative", "id", id));
        return new AlternativeResponse(
            alternative.getId(),
            alternative.getContent(),
            alternative.getImagePath(),
            alternative.getIsCorrect(),
            alternative.getQuestion().getId()
        );
    }

    @Override
    public AlternativeResponse createAlternative(AlternativeRequest alternativeRequest) {
        Question question = questionRepository.findById(alternativeRequest.questionId())
            .orElseThrow(() -> new ResourceNotFoundException("Question", "id", alternativeRequest.questionId()));
        Alternative alternative = new Alternative();
        alternative.setContent(alternativeRequest.content());
        alternative.setImagePath(alternativeRequest.imagePath()); // TODO: Se deberá considerar agregar imagen
        alternative.setIsCorrect(alternativeRequest.isCorrect() == null ? false : alternativeRequest.isCorrect());
        alternative.setQuestion(question);
        alternative = alternativeRepository.save(alternative);
        return new AlternativeResponse(
            alternative.getId(),
            alternative.getContent(),
            alternative.getImagePath(),
            alternative.getIsCorrect(),
            alternative.getQuestion().getId()
        );
    }

    @Override
    public AlternativeResponse updateAlternative(Long id, AlternativeRequest alternativeRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAlternative'");
    }

    @Override
    public void deleteAlternative(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAlternative'");
    }
    
}
