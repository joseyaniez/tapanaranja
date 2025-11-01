
package com.joseyaniez.tapanaranja.features.courses.model.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * CourseUpdateResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CourseUpdateResponse(
    Long id,
    String name,
    List<String> categoryNames
) {
}
