
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * ChapterRequest
 */
public record ChapterRequest(
    @NotBlank
    String name,
    @NotNull
    Long courseId
) {}
