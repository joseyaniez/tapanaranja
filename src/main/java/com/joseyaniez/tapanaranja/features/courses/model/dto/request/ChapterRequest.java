
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;

import com.joseyaniez.tapanaranja.features.courses.model.entity.Course;

/**
 * ChapterRequest
 */
public record ChapterRequest(
    String name,
    Course course
) {}
