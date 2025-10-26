
package com.joseyaniez.tapanaranja.core.exception.business;

import org.springframework.http.HttpStatus;

/**
 * ResourceNotFoundException
 */
public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue){
        super(
            "RESOURCE_NOT_FOUND",
            String.format("El recurso %s con %s '%s' no existe", resourceName, fieldName, fieldValue),
            HttpStatus.NOT_FOUND
        );
    }
}
