
package com.joseyaniez.tapanaranja.features.courses.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.SectionRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.SectionResponse;
import com.joseyaniez.tapanaranja.features.courses.service.SectionService;
import com.joseyaniez.tapanaranja.features.courses.service.impl.SectionServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;


/**
 * SectionController
 */
@RestController
@RequestMapping("/sections")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionServiceImpl sectionServiceImpl){
        this.sectionService = sectionServiceImpl;
    }


    @PostMapping
    public ApiResponse<SectionResponse> create(@RequestBody @Valid SectionRequest sectionRequest){
        SectionResponse response = sectionService.createSection(sectionRequest);
        return new ApiResponse<SectionResponse>(true, response, "Section creado");
    }

    @GetMapping("/{id}")
    public ApiResponse<SectionResponse> getById(@PathVariable Long id){
        SectionResponse response = sectionService.getSectionById(id);
        return new ApiResponse<SectionResponse>(true, response, null);
    }

    @PutMapping("/{id}")
    public ApiResponse<SectionResponse> update(@PathVariable Long id, @RequestBody @Valid SectionRequest sectionRequest){
        SectionResponse response = sectionService.updateSection(id, sectionRequest);
        return new ApiResponse<SectionResponse>(true, response, "Section actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        sectionService.deleteSection(id);
        return ResponseEntity.noContent().build();
    }

    
}
