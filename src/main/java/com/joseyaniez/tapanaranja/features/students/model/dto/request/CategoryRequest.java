
package com.joseyaniez.tapanaranja.features.students.model.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * CategoryRequest
 */
public class CategoryRequest {
    @NotBlank(message = "Debes indicar un nombre para la categoría")
    private String name;
}
