
package com.joseyaniez.tapanaranja.features.exams.model.dto.request;

import com.joseyaniez.tapanaranja.features.courses.model.entity.Section;

/**
 * QuestionRequest
 */
public record QuestionRequest(
    String content,
    String imagePath,
    Section section
) {}
