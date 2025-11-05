
package com.joseyaniez.tapanaranja.features.exams.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.exams.model.dto.request.QuestionRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.QuestionResponse;
import com.joseyaniez.tapanaranja.features.exams.model.entity.Question;
import com.joseyaniez.tapanaranja.features.exams.repository.QuestionRepository;
import com.joseyaniez.tapanaranja.features.exams.service.QuestionService;

import lombok.RequiredArgsConstructor;

/**
 * QuestionServiceImpl
 */
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

	@Override
	public List<QuestionResponse> getQuestionsByCourse(Long courseId, int size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getQuestionsByCourse'");
	}

	@Override
	public List<QuestionResponse> getQuestionsByChapter(Long chapterId, int size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getQuestionsByChapter'");
	}

	@Override
	public List<QuestionResponse> getQuestionsBySection(Long sectionId, int size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getQuestionsBySection'");
	}

	@Override
	public QuestionResponse getQuestionById(Long id) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        return new QuestionResponse(question.getId(), question.getContent(), question.getImagePath());
	}

	@Override
	public QuestionResponse createQuestion(QuestionRequest questionRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createQuestion'");
	}

	@Override
	public QuestionResponse updateQuestion(QuestionRequest questionRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateQuestion'");
	}

	@Override
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteQuestion'");
	}

    
}
