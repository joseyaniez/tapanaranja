
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * SectionRequest
 */
public record SectionRequest(
    @NotBlank
    String name,
    @NotNull
    Long chapterId
) {
}
