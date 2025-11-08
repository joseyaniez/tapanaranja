
package com.joseyaniez.tapanaranja.features.courses.service.impl;

import org.springframework.stereotype.Service;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceAlreadyHasChildren;
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
        Section section = sectionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Section", "id", id));
        return new SectionResponse(section.getId(), section.getName(), section.getChapter().getName());
	}

	@Override
	public SectionResponse createSection(SectionRequest sectionRequest) {
        Chapter chapter = chapterRepository.findById(sectionRequest.chapterId())
            .orElseThrow(() -> new ResourceNotFoundException("Chapter", "id", sectionRequest.chapterId()));
        Section section = new Section();
        section.setName(sectionRequest.name());
        section.setChapter(chapter);
        section = sectionRepository.save(section);
        return new SectionResponse(section.getId(), section.getName(), section.getChapter().getName());

	}

	@Override
	public SectionResponse updateSection(Long id, SectionRequest sectionRequest) {
        Section section = sectionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Section", "id", id));
        if(!section.getName().equals(sectionRequest.name())){
            section.setName(sectionRequest.name());
        }
        Chapter chapter = chapterRepository.findById(sectionRequest.chapterId())
            .orElseThrow(() -> new ResourceNotFoundException("Chapter", "id", sectionRequest.chapterId()));
        section.setChapter(chapter);
        section = sectionRepository.save(section);
        return new SectionResponse(section.getId(), section.getName(), section.getChapter().getName());
	}

	@Override
	public void deleteSection(Long id) {
        Section section = sectionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Section", "id", id));
        if(!section.getQuestions().isEmpty()){
            throw new ResourceAlreadyHasChildren("Section", "Question");
        }
        sectionRepository.delete(section);
	}

    
}
