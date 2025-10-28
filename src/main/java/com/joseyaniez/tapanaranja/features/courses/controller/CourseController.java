
package com.joseyaniez.tapanaranja.features.courses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseResponse;
import com.joseyaniez.tapanaranja.features.courses.service.CourseService;
import com.joseyaniez.tapanaranja.features.courses.service.impl.CourseServiceImpl;

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
    
}
