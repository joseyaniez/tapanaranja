
package com.joseyaniez.tapanaranja.features.exams.model.dto.response;

/**
 * QuestionResponse
 */
public record QuestionResponse(
    Long id,
    String content,
    String imagePath,
    String sectionId
) {
}
