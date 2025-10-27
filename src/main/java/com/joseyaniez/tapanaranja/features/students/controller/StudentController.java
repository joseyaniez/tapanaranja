
package com.joseyaniez.tapanaranja.features.students.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.StudentResponse;
import com.joseyaniez.tapanaranja.features.students.service.StudentService;
import com.joseyaniez.tapanaranja.features.students.service.impl.StudentServiceImpl;

/**
 * StudentController
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentServiceImpl studentServiceImpl){
        this.studentService = studentServiceImpl;
    }

    @GetMapping("/{id}")
    public ApiResponse<StudentResponse> getById(@PathVariable Long id){
        StudentResponse student = studentService.getById(id);
        return new ApiResponse<StudentResponse>(true, student, null);
    }

    
}
