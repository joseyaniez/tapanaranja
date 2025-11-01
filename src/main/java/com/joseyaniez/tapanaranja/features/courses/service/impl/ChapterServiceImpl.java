
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getChapterById'");
	}

	@Override
	public ChapterResponse createChapter(ChapterRequest chapterRequest) {
        Course course = courseRepository.findById(chapterRequest.courseId())
            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", chapterRequest.courseId()));
        Chapter chapter = new Chapter();
        chapter.setName(chapterRequest.name());
        chapter.setCourse(course);
        chapter = chapterRepository.save(chapter);
        return new ChapterResponse(chapter.getName(), course.getId());
	}

	@Override
	public ChapterResponse updateChapter(Long id, ChapterRequest chapterRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateChapter'");
	}

	@Override
	public void deleteChapter(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteChapter'");
	}

    
}
