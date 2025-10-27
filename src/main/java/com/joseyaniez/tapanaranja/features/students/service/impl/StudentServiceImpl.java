
package com.joseyaniez.tapanaranja.features.students.service.impl;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.students.model.dto.request.StudentRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.StudentResponse;
import com.joseyaniez.tapanaranja.features.students.model.entity.Student;
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

	@Override
	public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        return new StudentResponse(student.getId(), student.getUsername(), student.getCategory().getId());
	}

	@Override
	public StudentResponse create(StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'create'");
	}

	@Override
	public StudentResponse update(Long id, StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

    
}
