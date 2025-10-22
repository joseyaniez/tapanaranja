
package com.joseyaniez.tapanaranja.features.students.service.impl;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.features.students.model.dto.request.CategoryRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.CategoryResponse;
import com.joseyaniez.tapanaranja.features.students.model.entity.Category;
import com.joseyaniez.tapanaranja.features.students.repository.CategoryRepository;
import com.joseyaniez.tapanaranja.features.students.service.CategoryService;

import lombok.RequiredArgsConstructor;

/**
 * CategoryServiceImpl
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

	@Override
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        CategoryResponse response = new CategoryResponse(category.getName());
        return response;
	}

	@Override
	public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
	}

}
