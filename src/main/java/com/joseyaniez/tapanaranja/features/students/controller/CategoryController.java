
package com.joseyaniez.tapanaranja.features.students.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.features.students.model.dto.request.CategoryRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.CategoryResponse;
import com.joseyaniez.tapanaranja.features.students.service.impl.CategoryServiceImpl;

import jakarta.validation.Valid;

/**
 * CategoryController
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryServiceImpl){
        this.categoryService = categoryServiceImpl;
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return categoryResponse;
    }
    
}
