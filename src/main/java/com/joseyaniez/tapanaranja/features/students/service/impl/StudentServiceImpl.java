
package com.joseyaniez.tapanaranja.features.students.service.impl;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceAlreadyExistsException;
import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.students.model.dto.request.StudentRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.StudentResponse;
import com.joseyaniez.tapanaranja.features.students.model.entity.Category;
import com.joseyaniez.tapanaranja.features.students.model.entity.Student;
import com.joseyaniez.tapanaranja.features.students.repository.CategoryRepository;
import com.joseyaniez.tapanaranja.features.students.repository.StudentRepository;
import com.joseyaniez.tapanaranja.features.students.service.StudentService;

import lombok.RequiredArgsConstructor;

/**
 * StudentServiceImpl
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CategoryRepository categoryRepository;

	@Override
	public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        return new StudentResponse(student.getId(), student.getUsername(), student.getCategory().getId());
	}

	@Override
	public StudentResponse create(StudentRequest studentRequest) {
        if(studentRepository.existsByUsername(studentRequest.getUsername())){
            throw new ResourceAlreadyExistsException("Student", "username", studentRequest.getUsername());
        }
        Category category = categoryRepository
            .findById(studentRequest.getCategoty_id())
            .orElseThrow(() -> new ResourceNotFoundException("Category", "id", studentRequest.getCategoty_id()));
        Student student = new Student();
        student.setUsername(studentRequest.getUsername());
        student.setCategory(category);
        student = studentRepository.save(student);
        return new StudentResponse(student.getId(), student.getUsername(), student.getCategory().getId());
	}

	@Override
	public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = studentRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        if(student.getUsername().equals(studentRequest.getUsername()) || studentRepository.existsByUsername(studentRequest.getUsername())){
            throw new ResourceAlreadyExistsException("Student", "username", studentRequest.getUsername());
        }
        Category category = categoryRepository
            .findById(studentRequest.getCategoty_id())
            .orElseThrow(() -> new ResourceNotFoundException("Category", "id", studentRequest.getCategoty_id()));
        student.setUsername(studentRequest.getUsername());
        if(!student.getCategory().equals(category)){
            student.setCategory(category);
        }
        student = studentRepository.save(student);
        return new StudentResponse(student.getId(), student.getUsername(), student.getCategory().getId());
	}

	@Override
	public void delete(Long id) {
        Student student = studentRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        studentRepository.delete(student);
	}

    
}
