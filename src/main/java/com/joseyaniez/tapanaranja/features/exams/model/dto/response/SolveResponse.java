
package com.joseyaniez.tapanaranja.features.exams.model.dto.response;

/**
 * SolveResponse
 */
public record SolveResponse(
    Long id,
    String content,
    String imagePath,
    String courseId
) {
}
