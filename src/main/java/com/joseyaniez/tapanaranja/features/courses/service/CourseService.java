
package com.joseyaniez.tapanaranja.features.courses.service;

import java.util.List;

import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseUpdateResponse;


/**
 * CourseService
 */
public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseById(Long id);
    CourseResponse createCourse(CourseRequest courseRequest);
    CourseUpdateResponse updateCourseName(Long id, String courseName);
    CourseUpdateResponse updateCourseCategories(Long id, List<Long> categoryIds);
    void deleteCourse(Long id);
}
