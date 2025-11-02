
package com.joseyaniez.tapanaranja.features.courses.service.impl;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.features.courses.model.dto.request.SectionRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.SectionResponse;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Chapter;
import com.joseyaniez.tapanaranja.features.courses.model.entity.Section;
import com.joseyaniez.tapanaranja.features.courses.repository.ChapterRepository;
import com.joseyaniez.tapanaranja.features.courses.repository.SectionRepository;
import com.joseyaniez.tapanaranja.features.courses.service.SectionService;

import lombok.RequiredArgsConstructor;

/**
 * SectionServiceImpl
 */
@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final ChapterRepository chapterRepository;

	@Override
	public SectionResponse getSectionById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSectionById'");
	}

	@Override
	public SectionResponse createSection(SectionRequest sectionRequest) {
        Chapter chapter = chapterRepository.findById(sectionRequest.chapterId())
            .orElseThrow(() -> new ResourceNotFoundException("Chapter", "id", sectionRequest.chapterId()));
        Section section = new Section();
        section.setName(sectionRequest.name());
        section.setChapter(chapter);
        section = sectionRepository.save(section);
        return new SectionResponse(section.getName(), section.getChapter().getName());

	}

	@Override
	public SectionResponse updateSection(Long id, SectionRequest sectionRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateSection'");
	}

	@Override
	public void deleteSection(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteSection'");
	}

    
}
