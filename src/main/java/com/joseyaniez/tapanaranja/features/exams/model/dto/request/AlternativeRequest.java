
package com.joseyaniez.tapanaranja.features.exams.model.dto.request;

import com.joseyaniez.tapanaranja.features.exams.model.entity.Question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * AlternativeRequest
 */
public record AlternativeRequest(
    @NotBlank
    String content,
    String imagePath, //TODO: agregar campo de imagen real
    Boolean isCorrect,
    @NotNull
    Long questionId
) {
}
