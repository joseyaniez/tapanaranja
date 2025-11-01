
package com.joseyaniez.tapanaranja.features.courses.model.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CourseUpdateCategoriesRequest
 */
@NoArgsConstructor
@Data
public class CourseUpdateCategoriesRequest {
    @NotNull
    private List<Long> categoryIds;
}
