
package com.joseyaniez.tapanaranja.features.exams.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * QuestionRequest
 */
public record QuestionRequest(
    @NotBlank
    String content,
    String imagePath,
    @NotNull
    Long sectionId
) {}
