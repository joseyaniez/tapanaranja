
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
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.joseyaniez.tapanaranja.core.exception.business.ResourceAlreadyExistsException;
import com.joseyaniez.tapanaranja.core.exception.business.ResourceAlreadyHasChildren;
import com.joseyaniez.tapanaranja.core.exception.business.ResourceNotFoundException;
import com.joseyaniez.tapanaranja.core.exception.response.ErrorResponse;

/**
 * AppExceptionHandler
 */
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ResourceAlreadyHasChildren.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(ResourceAlreadyHasChildren ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            new ErrorResponse(
                ex.getCode(),
                ex.getMessage(),
                ex.getStatus().value(),
                LocalDateTime.now()
            )
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ErrorResponse(
                ex.getCode(),
                ex.getMessage(),
                ex.getStatus().value(),
                LocalDateTime.now()
            )
        );
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(ResourceAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            new ErrorResponse(
                ex.getCode(),
                ex.getMessage(),
                ex.getStatus().value(),
                LocalDateTime.now()
            )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationError(MethodArgumentNotValidException ex){
        Map<String, Object> errorMapResponse = new HashMap<>();
        ex.getFieldErrors().forEach( error -> 
            errorMapResponse.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMapResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeParamError(MethodArgumentTypeMismatchException ex) {
        String name = ex.getName(); // nombre del parámetro (p. ej. "id")
        String type = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconocido";
        String message = String.format("El parámetro '%s' debe ser de tipo %s.", name, type);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ErrorResponse(
                "argument_type_error",
                message,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
            )
        );

    }

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
