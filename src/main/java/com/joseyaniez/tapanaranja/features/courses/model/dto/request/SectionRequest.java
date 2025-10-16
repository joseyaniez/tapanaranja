
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;

import com.joseyaniez.tapanaranja.features.courses.model.entity.Chapter;

/**
 * SectionRequest
 */
public record SectionRequest(
    String name,
    Chapter chapter
) {
}
