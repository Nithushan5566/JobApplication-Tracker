package com.jobApplicationTracker.JobApplicationTracker.exception;


import com.jobApplicationTracker.JobApplicationTracker.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException e){
        ErrorResponse error=new ErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e){
        List<FieldError> errors=e.getBindingResult().getFieldErrors();
        Map<String, String> validationErrors=new HashMap<>();
        for(FieldError error: errors){
            String field= error.getField();
            String message=error.getDefaultMessage();
            validationErrors.put(field,message);

        }
        ErrorResponse errorResponse=new ErrorResponse(validationErrors,HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }



}
