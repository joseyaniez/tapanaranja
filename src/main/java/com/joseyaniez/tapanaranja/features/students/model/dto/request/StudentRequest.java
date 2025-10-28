
package com.joseyaniez.tapanaranja.features.students.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StudentRequest
 */
@Data
@NoArgsConstructor
public class StudentRequest {
    @NotBlank(message = "Debes proporcionar un nombre de usuario")
    private String username;
    @NotNull(message = "Debes proporcionar un identificador de categoría")
    private Long categoty_id;
}
