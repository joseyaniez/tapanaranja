
package com.joseyaniez.tapanaranja.features.courses.service;

import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseResponse;

/**
 * CourseService
 */
public interface CourseService {
    CourseResponse getCourseById(Long id);
    CourseResponse createCourse(CourseRequest courseRequest);
    CourseResponse updateCourse(Long id, CourseRequest courseRequest);
    void deleteCourse(Long id);
}
