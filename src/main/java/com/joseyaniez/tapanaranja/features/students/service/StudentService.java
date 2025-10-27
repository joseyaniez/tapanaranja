
package com.joseyaniez.tapanaranja.features.students.service;

import com.joseyaniez.tapanaranja.features.students.model.dto.request.StudentRequest;
import com.joseyaniez.tapanaranja.features.students.model.entity.Student;

/**
 * StudentService
 */
public interface StudentService {
    Student getById(Long id);
    Student create(StudentRequest studentRequest);
    Student update(Long id, StudentRequest studentRequest);
    void delete(Long id);
}
