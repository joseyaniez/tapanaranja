
package com.joseyaniez.tapanaranja.features.courses.service;

import com.joseyaniez.tapanaranja.features.courses.model.dto.request.SectionRequest;
import com.joseyaniez.tapanaranja.features.courses.model.dto.response.SectionResponse;

/**
 * SectionService
 */
public interface SectionService {

    SectionResponse getSectionById(Long id);
    SectionResponse createSection(SectionRequest sectionRequest);
    SectionResponse updateSection(Long id, SectionRequest sectionRequest);
    void deleteSection(Long id);
}
