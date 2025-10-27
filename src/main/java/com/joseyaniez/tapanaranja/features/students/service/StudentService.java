
package com.joseyaniez.tapanaranja.features.students.service;

import com.joseyaniez.tapanaranja.features.students.model.dto.request.StudentRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.StudentResponse;

/**
 * StudentService
 */
public interface StudentService {
    StudentResponse getById(Long id);
    StudentResponse create(StudentRequest studentRequest);
    StudentResponse update(Long id, StudentRequest studentRequest);
    void delete(Long id);
}
