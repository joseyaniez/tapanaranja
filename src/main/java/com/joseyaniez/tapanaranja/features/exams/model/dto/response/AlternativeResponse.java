
package com.joseyaniez.tapanaranja.features.exams.model.dto.response;

/**
 * AlternativeResponse
 */
public record AlternativeResponse(
    Long id,
    String content,
    String imagePath,
    Boolean isCorrect,
    String questionId
) {
}
