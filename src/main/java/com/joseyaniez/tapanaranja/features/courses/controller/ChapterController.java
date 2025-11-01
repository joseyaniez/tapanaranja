
package com.joseyaniez.tapanaranja.features.courses.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseyaniez.tapanaranja.core.web.response.ApiResponse;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.ChapterRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.ChapterResponse;
import com.joseyaniez.tapanaranja.features.courses.service.ChapterService;
import com.joseyaniez.tapanaranja.features.courses.service.impl.ChapterServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * ChapterController
 */
@RestController
@RequestMapping("chapters")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterServiceImpl chapterServiceImpl){
        this.chapterService = chapterServiceImpl;
    }

    @PostMapping
    public ApiResponse<ChapterResponse> create(@RequestBody @Valid ChapterRequest chapterRequest){
        ChapterResponse response = chapterService.createChapter(chapterRequest);
        return new ApiResponse<ChapterResponse>(true, response, "Chapter creado");
    }

    @GetMapping("/{id}")
    public ApiResponse<ChapterResponse> getById(@PathVariable Long id){
        ChapterResponse response = chapterService.getChapterById(id);
        return new ApiResponse<ChapterResponse>(true, response, null);
    }

    @PutMapping("/{id}")
    public ApiResponse<ChapterResponse> update(@PathVariable Long id, @RequestBody @Valid ChapterRequest chapterRequest){
        ChapterResponse response = chapterService.updateChapter(id, chapterRequest);
        return new ApiResponse<ChapterResponse>(true, response, "Chapter actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        chapterService.deleteChapter(id);
        return ResponseEntity.noContent().build();
    }
    
}
