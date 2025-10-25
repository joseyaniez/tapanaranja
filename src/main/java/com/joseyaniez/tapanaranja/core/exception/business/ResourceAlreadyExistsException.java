
package com.joseyaniez.tapanaranja.core.exception.business;

import org.springframework.http.HttpStatus;

/**
 * ResourceAlreadyExistsException
 */
public class ResourceAlreadyExistsException extends BusinessException {

    public ResourceAlreadyExistsException(String resourceName, String fieldName, Object fieldValue){
        super(
            "RESOURCE_ALREADY_EXISTS", 
            String.format("El recurso '%s' con %s '%s' ya existe.", resourceName, fieldName, fieldValue),
            HttpStatus.CONFLICT
        );
    }
    
}
