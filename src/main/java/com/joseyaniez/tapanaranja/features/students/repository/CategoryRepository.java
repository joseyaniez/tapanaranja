
package com.joseyaniez.tapanaranja.features.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseyaniez.tapanaranja.features.students.model.entity.Category;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends JpaRepository<Category, Long>{
    boolean existsByName(String name);
}
