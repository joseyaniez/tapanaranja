
package com.joseyaniez.tapanaranja.features.students.service;

import com.joseyaniez.tapanaranja.features.students.model.dto.request.StudentRequest;
import com.joseyaniez.tapanaranja.features.students.model.entity.Student;

/**
 * StudentService
 */
public interface StudentService {
    Student getStudentById(Long id);
    Student createStudent(StudentRequest studentRequest);
    Student updateStudent(Long id, StudentRequest studentRequest);
    void deleteStudent(Long id);
}
