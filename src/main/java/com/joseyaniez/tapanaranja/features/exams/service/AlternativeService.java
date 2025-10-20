
package com.joseyaniez.tapanaranja.features.exams.service;

import java.util.List;

import com.joseyaniez.tapanaranja.features.exams.model.dto.request.AlternativeRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.AlternativeResponse;

/**
 * AlternativeService
 */
public interface AlternativeService {
    List<AlternativeResponse> getAlternativebyCourse(Long questionId);
    AlternativeResponse getAlternativeById(Long id);
    AlternativeResponse createAlternative(AlternativeRequest alternativeRequest);
    AlternativeResponse updateAlternative(Long id, AlternativeRequest alternativeRequest);
    void deleteAlternative(Long id);
}
