
package com.joseyaniez.tapanaranja.core.exception.business;

import org.springframework.http.HttpStatus;

/**
 * ResourceAlreadyHasChildren
 */
public class ResourceAlreadyHasChildren extends BusinessException {

    public ResourceAlreadyHasChildren(String resourceName, String resourceChild){
        super(
            "RESOURCE_ALREADY_HAS_CHILDREN",
            String.format("El recurso %s contiene recursos '%s', por lo que no se puede eliminar", resourceName, resourceChild),
            HttpStatus.CONFLICT
        );
    }
    
}
