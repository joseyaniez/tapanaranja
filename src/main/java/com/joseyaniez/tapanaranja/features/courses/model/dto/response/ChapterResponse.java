
package com.joseyaniez.tapanaranja.features.courses.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ChapterResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChapterResponse(
    Long id,
    String name,
    Long courseId,
    Integer chapterOrder
) {}
