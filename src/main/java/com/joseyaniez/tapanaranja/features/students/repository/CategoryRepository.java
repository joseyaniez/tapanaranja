
package com.joseyaniez.tapanaranja.features.students.repository;

import org.springframework.data.repository.CrudRepository;

import com.joseyaniez.tapanaranja.features.students.model.entity.Category;

/**
 * CategoryRepository
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{

    
}
