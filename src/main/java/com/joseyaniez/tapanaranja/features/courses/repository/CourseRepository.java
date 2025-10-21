
package com.joseyaniez.tapanaranja.features.courses.repository;

import org.springframework.data.repository.CrudRepository;

import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;

/**
 * CourseRepository
 */
public interface CourseRepository extends CrudRepository<Course, Long> {

    
}
