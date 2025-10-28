
package com.joseyaniez.tapanaranja.features.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;

/**
 * CourseRepository
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

    
}
