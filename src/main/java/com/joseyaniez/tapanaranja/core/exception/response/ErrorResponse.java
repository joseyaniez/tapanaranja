
package com.joseyaniez.tapanaranja.core.exception.response;

import java.time.LocalDateTime;

/**
 * ErrorResponse
 */
public record ErrorResponse(
    String typeError,
    String message,
    int status,
    LocalDateTime timestamp
) {}
