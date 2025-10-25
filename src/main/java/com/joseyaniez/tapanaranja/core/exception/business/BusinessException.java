
package com.joseyaniez.tapanaranja.core.exception.business;

import org.springframework.http.HttpStatus;

/**
 * BusinessException
 */
public abstract class BusinessException extends RuntimeException {

    private final String code;
    private final HttpStatus status;

    public BusinessException(String code, String message, HttpStatus status){
        super(message);
        this.code = code;
        this.status = status;
    }

    public String getCode(){
        return this.code;
    }

    public HttpStatus getStatus(){
        return this.status;
    }

    
}
