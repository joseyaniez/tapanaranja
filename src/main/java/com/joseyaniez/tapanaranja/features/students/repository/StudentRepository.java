
package com.joseyaniez.tapanaranja.features.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseyaniez.tapanaranja.features.students.model.entity.Student;

/**
 * StudentRepository
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByUsername(String username);
}
