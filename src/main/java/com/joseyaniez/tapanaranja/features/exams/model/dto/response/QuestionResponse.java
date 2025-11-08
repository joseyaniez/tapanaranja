
package com.joseyaniez.tapanaranja.features.exams.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * QuestionResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionResponse(
    Long id,
    String content,
    String imagePath
) {
}
