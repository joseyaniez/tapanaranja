
package com.joseyaniez.tapanaranja.features.exams.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * AlternativeResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AlternativeResponse(
    Long id,
    String content,
    String imagePath,
    Boolean isCorrect,
    Long questionId
) {
}
