package com.jobApplicationTracker.JobApplicationTracker.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private Map<String,String> errors;

    public ErrorResponse(String message,int status){
        this.message=message;
        this.status=status;
        this.timestamp=LocalDateTime.now();
    }

    public ErrorResponse(Map<String, String> errors, int status) {
        this.errors = errors;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
