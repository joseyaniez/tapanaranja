
package com.joseyaniez.tapanaranja.features.courses.service;

import com.joseyaniez.tapanaranja.features.courses.model.dto.request.ChapterRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.ChapterResponse;

/**
 * ChapterService
 */
public interface ChapterService {
    ChapterResponse getChapterById(Long id);
    ChapterResponse createChapter(ChapterRequest chapterRequest);
    ChapterResponse updateChapter(Long id, ChapterRequest chapterRequest);
    void deleteChapter(Long id);
}
