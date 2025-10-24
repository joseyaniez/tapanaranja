
package com.joseyaniez.tapanaranja.features.students.service;

import java.util.List;

import com.joseyaniez.tapanaranja.features.students.model.dto.request.CategoryRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.CategoryResponse;

/**
 * CategoryService
 */
public interface CategoryService {
    List<CategoryResponse> getAll();
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);
    void deleteCategory(Long id);
}
