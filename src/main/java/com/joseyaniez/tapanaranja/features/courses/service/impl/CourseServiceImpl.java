
package com.joseyaniez.tapanaranja.features.courses.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceAlreadyExistsException;
import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.CourseRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.CourseUpdateResponse;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;
import com.joseyaniez.tapanaranja.features.courses.repository.CourseRepository;
import com.joseyaniez.tapanaranja.features.courses.service.CourseService;
import com.joseyaniez.tapanaranja.features.students.model.entity.Category;
import com.joseyaniez.tapanaranja.features.students.repository.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * CourseServiceImpl
 */
@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

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
        if(courseRepository.existsByName(courseRequest.getName())){
            throw new ResourceAlreadyExistsException("Course", "name", courseRequest.getName());
        }

        Category category = categoryRepository.findById(courseRequest.getCategoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Category", "id", courseRequest.getCategoryId()));

        Course course = new Course();
        course.setName(courseRequest.getName());
        course = courseRepository.save(course);

        category.getCourses().add(course);
        category = categoryRepository.save(category);

        return new CourseResponse(
            course.getId(),
            course.getName()
        );
	}

	@Override
	public CourseUpdateResponse updateCourseName(Long id, String courseName) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        if(course.getName().equals(courseName) || courseRepository.existsByName(courseName)){
            throw new ResourceAlreadyExistsException("Course", "name", courseName);
        }
        course.setName(courseName);
        course = courseRepository.save(course);
        return new CourseUpdateResponse(id, course.getName(), null);
	}

    @Override
    @Transactional
    public CourseUpdateResponse updateCourseCategories(Long id, List<Long> categoryIds) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        List<Category> categories = categoryRepository.findAllById(categoryIds);
        course.getCategories().clear();
        course.setCategories(categories);
        course = courseRepository.save(course);
        var courseCategoryNames = course.getCategories().stream().map(cat -> cat.getName()).toList();
        return new CourseUpdateResponse(course.getId(), course.getName(), courseCategoryNames);
    }

	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
	}

    
}
