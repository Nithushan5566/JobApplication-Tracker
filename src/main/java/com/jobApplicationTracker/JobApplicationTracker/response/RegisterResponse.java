package com.jobApplicationTracker.JobApplicationTracker.response;
public class RegisterResponse {

    private Integer id;
    private String username;

    public RegisterResponse(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}