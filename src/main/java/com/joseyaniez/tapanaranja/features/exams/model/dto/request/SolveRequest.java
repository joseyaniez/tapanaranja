
package com.joseyaniez.tapanaranja.features.exams.model.dto.request;

import com.joseyaniez.tapanaranja.features.exams.model.entity.Question;

/**
 * SolveRequest
 */
public record SolveRequest(
    String content,
    String imagePath, //TODO: agregar campo de imagen
    Question question
) {
}
