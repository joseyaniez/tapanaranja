
package com.joseyaniez.tapanaranja.features.students.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.students.model.dto.request.StudentRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.StudentResponse;
import com.joseyaniez.tapanaranja.features.students.service.StudentService;
import com.joseyaniez.tapanaranja.features.students.service.impl.StudentServiceImpl;

import jakarta.validation.Valid;

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

    @PostMapping
    public ApiResponse<StudentResponse> create(@RequestBody @Valid StudentRequest studentRequest){
        StudentResponse student = studentService.create(studentRequest);
        return new ApiResponse<StudentResponse>(true, student, "Student creado");
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentResponse> update(@PathVariable Long id, @RequestBody @Valid StudentRequest studentRequest){
        StudentResponse student = studentService.update(id, studentRequest);
        return new ApiResponse<StudentResponse>(true, student, "Student actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
