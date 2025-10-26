
package com.joseyaniez.tapanaranja.features.students.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.students.model.dto.request.CategoryRequest;
import com.joseyaniez.tapanaranja.features.students.model.dto.response.CategoryResponse;
import com.joseyaniez.tapanaranja.features.students.service.impl.CategoryServiceImpl;

import jakarta.validation.Valid;

/**
 * CategoryController
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryServiceImpl){
        this.categoryService = categoryServiceImpl;
    }

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAll(){
        List<CategoryResponse> categories = categoryService.getAll();
        return new ApiResponse<>(true, categories, null);
    }

    @PostMapping
    public ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.create(categoryRequest);
        return new ApiResponse<>(true, categoryResponse, "Categoría insertada");
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.update(id, categoryRequest);
        return new ApiResponse<>(true, categoryResponse, "Categoría fue actualizada");
    }
    
}
