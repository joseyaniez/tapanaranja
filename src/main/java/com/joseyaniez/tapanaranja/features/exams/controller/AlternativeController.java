
package com.joseyaniez.tapanaranja.features.exams.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.exams.model.dto.request.AlternativeRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.AlternativeResponse;
import com.joseyaniez.tapanaranja.features.exams.service.AlternativeService;
import com.joseyaniez.tapanaranja.features.exams.service.impl.AlternativeServiceImpl;

import jakarta.validation.Valid;

/**
 * AlternativeController
 */
@RestController
@RequestMapping("/alternatives")
public class AlternativeController {

    private final AlternativeService alternativeService;

    public AlternativeController(AlternativeServiceImpl alternativeServiceImpl){
        this.alternativeService = alternativeServiceImpl;
    }

    @PostMapping
    public ApiResponse<AlternativeResponse> create(@RequestBody @Valid AlternativeRequest alternativeRequest){
        AlternativeResponse alternative = alternativeService.createAlternative(alternativeRequest);
        return new ApiResponse<AlternativeResponse>(true, alternative, "Alternativa creada");
    }

    @GetMapping("/{id}")
    public ApiResponse<AlternativeResponse> getById(@PathVariable Long id){
        AlternativeResponse alternative = alternativeService.getAlternativeById(id);
        return new ApiResponse<AlternativeResponse>(true, alternative, null);
    }

    @PutMapping("/{id}")
    public ApiResponse<AlternativeResponse> update(@PathVariable Long id, @RequestBody @Valid AlternativeRequest alternativeRequest){
        AlternativeResponse alternative = alternativeService.updateAlternative(id, alternativeRequest);
        return new ApiResponse<AlternativeResponse>(true, alternative, "Alternativa actualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alternativeService.deleteAlternative(id);
        return ResponseEntity.noContent().build();
    }
    
}
