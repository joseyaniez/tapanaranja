
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CourseRequest
 */
@Data
@NoArgsConstructor
public class CourseRequest {
    @NotBlank(message = "Debes proporcionar un nombre")
    private String name;

    @NotNull(message = "Se debe proporcionar un identificador de categoría")
    @JsonProperty("category_id")
    private Long categoryId;
}
