
package com.joseyaniez.tapanaranja.features.exams.model.dto.request;

import com.joseyaniez.tapanaranja.features.exams.model.entity.Question;

/**
 * AlternativeRequest
 */
public record AlternativeRequest(
    String content,
    String imagePath, //TODO: agregar campo de imagen real
    Boolean isCorrect,
    Question question
) {
}
