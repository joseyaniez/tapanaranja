
package com.joseyaniez.tapanaranja.features.courses.service.impl;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.ChapterRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.ChapterResponse;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Chapter;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;
import com.joseyaniez.tapanaranja.features.courses.repository.ChapterRepository;
import com.joseyaniez.tapanaranja.features.courses.repository.CourseRepository;
import com.joseyaniez.tapanaranja.features.courses.service.ChapterService;

import lombok.RequiredArgsConstructor;

/**
 * ChapterServiceImpl
 */
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final CourseRepository courseRepository;

	@Override
	public ChapterResponse getChapterById(Long id) {
        Chapter chapter = chapterRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Chapter", "id", id));
        return new ChapterResponse(chapter.getName(), chapter.getCourse().getId(), chapter.getChapterOrder());
	}

	@Override
	public ChapterResponse createChapter(ChapterRequest chapterRequest) {
        Course course = courseRepository.findById(chapterRequest.courseId())
            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", chapterRequest.courseId()));
        Chapter chapter = new Chapter();
        chapter.setName(chapterRequest.name());
        chapter.setCourse(course);
        if(chapterRequest.chapterOrder() != null){
            chapter.setChapterOrder(chapterRequest.chapterOrder());
        }
        chapter = chapterRepository.save(chapter);
        return new ChapterResponse(chapter.getName(), course.getId(), chapter.getChapterOrder());
	}

	@Override
	public ChapterResponse updateChapter(Long id, ChapterRequest chapterRequest) {
        Chapter chapter = chapterRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Chapter", "id", id));
        if(!chapter.getName().equals(chapterRequest.name())){
            chapter.setName(chapterRequest.name());
        }
        if(chapterRequest.chapterOrder() != null){
            chapter.setChapterOrder(chapterRequest.chapterOrder());
        }
        Course course = courseRepository.findById(chapterRequest.courseId())
            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", chapterRequest.courseId()));
        chapter.setCourse(course);
        chapter = chapterRepository.save(chapter);
        return new ChapterResponse(chapter.getName(), chapter.getCourse().getId(), chapter.getChapterOrder());
	}

	@Override
	public void deleteChapter(Long id) {
	}

    
}
