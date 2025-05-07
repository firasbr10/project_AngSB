package com.operation.maintenance.rest;

import com.operation.maintenance.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.operation.maintenance.wrapper.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handler pour l'exception ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse<String> response = ApiResponse.error(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    
 // Handler pour les erreurs de validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ApiResponse<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors().stream()
            .map(ObjectError::getDefaultMessage)
            .collect(Collectors.toList());
        
        ApiResponse<String> response = ApiResponse.error(String.join(", ", errorMessages), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    
}
