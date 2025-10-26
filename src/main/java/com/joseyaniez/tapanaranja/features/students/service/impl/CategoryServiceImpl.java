
package com.joseyaniez.tapanaranja.features.students.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceAlreadyExistsException;
import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
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

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryResponse> categories = categoryRepository.findAll().stream().map(category -> 
            new CategoryResponse(category.getId(), category.getName())
        ).toList();
        return categories;
    }

	@Override
	public CategoryResponse create(CategoryRequest categoryRequest) {
        if(categoryRepository.existsByName(categoryRequest.getName())){
            throw new ResourceAlreadyExistsException("Category", "name", categoryRequest.getName());
        }
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category = categoryRepository.save(category);
        CategoryResponse response = new CategoryResponse(category.getId(), category.getName());
        return response;
	}

	@Override
	public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        if(category.getName().equalsIgnoreCase(categoryRequest.getName()) || categoryRepository.existsByName(categoryRequest.getName())){
            throw new ResourceAlreadyExistsException("Category", "name", categoryRequest.getName());
        }
        category.setName(categoryRequest.getName());
        category = categoryRepository.save(category);
        CategoryResponse response = new CategoryResponse(category.getId(), category.getName());
        return response;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
	}

}
