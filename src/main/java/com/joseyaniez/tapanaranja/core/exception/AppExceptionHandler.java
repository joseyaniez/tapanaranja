
package com.joseyaniez.tapanaranja.core.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.joseyaniez.tapanaranja.core.exception.response.ErrorResponse;

/**
 * AppExceptionHandler
 */
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationError(MethodArgumentNotValidException ex){
        Map<String, Object> errorMapResponse = new HashMap<>();
        ex.getFieldErrors().forEach( error -> 
            errorMapResponse.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMapResponse);
    }

    // Ocurre cuando no se puede mapear el body a la clase dto
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ErrorResponse(
                "invalid_input",
                "El cuerpo de la petición es inválido o no está presete",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
            )
        );
    }
    
}
