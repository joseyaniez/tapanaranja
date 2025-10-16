
package com.joseyaniez.tapanaranja.features.students.model.dto.request;

import com.joseyaniez.tapanaranja.features.students.model.entity.Category;

/**
 * StudentRequest
 */
public record StudentRequest(
    String username,
    Category category
) {}
