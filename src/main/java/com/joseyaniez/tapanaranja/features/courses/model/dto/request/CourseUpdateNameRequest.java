
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

/**
 * CourseUpdateNameRequest
 */
public record CourseUpdateNameRequest(@NotEmpty String name) {
}
