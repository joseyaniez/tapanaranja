
package com.joseyaniez.tapanaranja.features.exams.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Section;
import com.joseyaniez.tapanaranja.features.courses.repository.SectionRepository;
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
    private final SectionRepository sectionRepository;

	@Override
	public List<QuestionResponse> getQuestionsByCourse(Long courseId, int size) {
		throw new UnsupportedOperationException("Unimplemented method 'getQuestionsByCourse'");
	}

	@Override
	public List<QuestionResponse> getQuestionsByChapter(Long chapterId, int size) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getQuestionsByChapter'");
	}

	@Override
	public List<QuestionResponse> getQuestionsBySection(Long sectionId, int size) {
        List<Question> questions = questionRepository.findBySectionId(sectionId);
        return questions.stream().map(q -> new QuestionResponse(q.getId(), q.getContent(), q.getImagePath())).toList();
	}

	@Override
	public QuestionResponse getQuestionById(Long id) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        return new QuestionResponse(question.getId(), question.getContent(), question.getImagePath());
	}

	@Override
	public QuestionResponse createQuestion(QuestionRequest questionRequest) {
        Section section = sectionRepository.findById(questionRequest.sectionId())
            .orElseThrow(() -> new ResourceNotFoundException("Section", "id", questionRequest.sectionId()));
        Question question = new Question();
        question.setContent(questionRequest.content());
        question.setImagePath(questionRequest.imagePath());
        question.setSection(section);
        question = questionRepository.save(question);
        return new QuestionResponse(question.getId(), question.getContent(), question.getImagePath());
	}

	@Override
	public QuestionResponse updateQuestion(Long id, QuestionRequest questionRequest) {
        Section section = sectionRepository.findById(questionRequest.sectionId())
            .orElseThrow(() -> new ResourceNotFoundException("Section", "id", questionRequest.sectionId()));
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        question.setContent(questionRequest.content());
        question.setImagePath(questionRequest.imagePath());
        question.setSection(section);
        question = questionRepository.save(question);
        return new QuestionResponse(question.getId(), question.getContent(), question.getImagePath());
	}

	@Override
	public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        questionRepository.delete(question);
	}

    
}
