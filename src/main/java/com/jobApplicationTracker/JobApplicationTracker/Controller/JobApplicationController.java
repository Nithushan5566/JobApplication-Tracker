package com.jobApplicationTracker.JobApplicationTracker.Controller;

import com.jobApplicationTracker.JobApplicationTracker.Model.JobApplication;
import com.jobApplicationTracker.JobApplicationTracker.Service.JobApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;
    @Operation(
            summary = "Get applications with pagination",
            description = "Retrieves job application using pagination."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Applications retrieved successfully with pagination")
    })
    @GetMapping("/applications/page")
    public ResponseEntity<Page<JobApplication>> getApplication(Pageable pageable){
        return new ResponseEntity<>(service.getApplication(pageable),HttpStatus.OK);
    }



    @Operation(
            summary = "Get all applications",
            description = "Retrieves job applications with optional filtering by company, status, and location."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Applications retrieved successfully")
    })
    @GetMapping("/applications")
    public ResponseEntity<List<JobApplication>> getAllApplication(@Parameter(description = "Filter application by company name")@RequestParam(required = false)String company,@Parameter(description = "Filter application by application status")@RequestParam(required=false)String status,
                                                                 @Parameter(description = "Filter application by job location") @RequestParam(required=false)String location) {

        return new ResponseEntity<>(service.getAllApplications(company,status,location), HttpStatus.OK);
    }


    @Operation(
            summary= "Get application by ID",
            description = "Retrieves a job application using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Application found successfully"),
            @ApiResponse(responseCode = "404",description = "Application not found")
    })
    @GetMapping("/applications/{id}")
    public ResponseEntity<JobApplication> findById(@Parameter(description = "Unique ID of the job application") @PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Create a new application",
            description = "Create and saves a new job application. "
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Application created successfully"),
            @ApiResponse(responseCode = "400",description = "Invalid application data")
    })
    @PostMapping("/applications")
    public ResponseEntity<JobApplication> createApplication(@Valid @RequestBody JobApplication application) {
        return new ResponseEntity<>(service.createApplication(application), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Delete application by ID",
            description = "Deletes a job application using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Application deleted successfully"),
            @ApiResponse(responseCode = "404",description = "Application not found")
    })
    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> deleteApplication(@Parameter(description = "Unique ID of the job application")@PathVariable int id) {
        service.deleteApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @Operation(
            summary = "Update application by ID",
            description = "Updates an existing job application using its unique ID. "
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Application updated successfully"),
            @ApiResponse(responseCode = "400",description = "Invalid application data"),
            @ApiResponse(responseCode = "404",description = "Application not found")
    })
    @PutMapping("/applications/{id}")
    public ResponseEntity<JobApplication> updateApplication(@Parameter(description = "Unique ID of the job application")@PathVariable int id,@Valid @RequestBody JobApplication application) {
        return new ResponseEntity<>(service.updateApplication(id, application), HttpStatus.OK);


    }
}
