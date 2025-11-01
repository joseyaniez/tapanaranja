
package com.joseyaniez.tapanaranja.features.courses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseUpdateCategoriesRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseUpdateNameRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseUpdateResponse;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;
import com.joseyaniez.tapanaranja.features.courses.service.CourseService;
import com.joseyaniez.tapanaranja.features.courses.service.impl.CourseServiceImpl;

import jakarta.validation.Valid;

/**
 * CourseController
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseServiceImpl courseServiceImpl){
        this.courseService = courseServiceImpl;
    }

    @GetMapping
    public ApiResponse<List<CourseResponse>> getAll(){
        List<CourseResponse> courses = courseService.getAllCourses();
        return new ApiResponse<List<CourseResponse>>(true, courses, null);
    }

    @GetMapping("/{id}")
    public ApiResponse<CourseResponse> getById(@PathVariable Long id){
        CourseResponse course = courseService.getCourseById(id);
        return new ApiResponse<CourseResponse>(true, course, null);
    }

    @PostMapping
    public ApiResponse<CourseResponse> create(@RequestBody @Valid CourseRequest courseRequest){
        CourseResponse course = courseService.createCourse(courseRequest);
        return new ApiResponse<CourseResponse>(true, course, "Course creado");
    }

    @PutMapping("/{id}")
    public ApiResponse<CourseUpdateResponse> updateName(@PathVariable Long id, @RequestBody @Valid CourseUpdateNameRequest catReq){
        CourseUpdateResponse course = courseService.updateCourseName(id, catReq.name());
        return new ApiResponse<CourseUpdateResponse>(true, course, "Curso actualizado");
    }

    @PutMapping("/{id}/categories")
    public ApiResponse<CourseUpdateResponse> updateCategories(@PathVariable Long id, @RequestBody @Valid CourseUpdateCategoriesRequest catReq){
        CourseUpdateResponse course = courseService.updateCourseCategories(id, catReq.getCategoryIds());
        return new ApiResponse<CourseUpdateResponse>(true, course, "Curso actualizado");
    }
    
}
