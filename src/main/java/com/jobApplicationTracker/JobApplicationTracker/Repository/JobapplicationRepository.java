package com.jobApplicationTracker.JobApplicationTracker.Repository;

import com.jobApplicationTracker.JobApplicationTracker.Model.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobapplicationRepository extends JpaRepository<JobApplication,Integer> {
    List<JobApplication> findByCompany(String company);
    List<JobApplication> findByStatus(String status);
    List<JobApplication> findByLocation(String location);
    List<JobApplication> findByCompanyAndStatus(String company,String status);
    List<JobApplication> findByCompanyAndStatusAndLocation(String company,String status,String Location);
    Page<JobApplication> findAll(Pageable pageable);
}
