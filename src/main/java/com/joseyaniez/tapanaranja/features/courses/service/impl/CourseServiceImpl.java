
package com.joseyaniez.tapanaranja.features.courses.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseResponse;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;
import com.joseyaniez.tapanaranja.features.courses.repository.CourseRepository;
import com.joseyaniez.tapanaranja.features.courses.service.CourseService;

import lombok.RequiredArgsConstructor;

/**
 * CourseServiceImpl
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

	@Override
	public List<CourseResponse> getAllCourses() {
        List<CourseResponse> courses = courseRepository
            .findAll()
            .stream()
            .map(course -> new CourseResponse(course.getId(), course.getName()))
            .toList();
        return courses;
	}

	@Override
	public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        CourseResponse response = new CourseResponse(course.getId(), course.getName());
        return response;
	}

	@Override
	public CourseResponse createCourse(CourseRequest courseRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createCourse'");
	}

	@Override
	public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateCourse'");
	}

	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
	}

    
}
