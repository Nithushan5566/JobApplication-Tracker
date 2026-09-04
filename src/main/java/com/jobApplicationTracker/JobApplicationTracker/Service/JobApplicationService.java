package com.jobApplicationTracker.JobApplicationTracker.Service;


import com.jobApplicationTracker.JobApplicationTracker.Model.JobApplication;
import com.jobApplicationTracker.JobApplicationTracker.Repository.JobapplicationRepository;
import com.jobApplicationTracker.JobApplicationTracker.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobapplicationRepository repo;

    public Page<JobApplication> getApplication(Pageable pageable){
        return repo.findAll(pageable);
    }

    public JobApplication  findById(int id){
        Optional<JobApplication> result =repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
            throw new ResourceNotFoundException("Application not found with id: "+id);
        }
    }

    public JobApplication createApplication(JobApplication application){
          return repo.save(application);

    }
    public List<JobApplication> getAllApplications(String company,String status,String location){
        if((company!=null && !company.isBlank()) && (status!=null && !status.isBlank()) && (location!=null && !location.isBlank())) {
            return repo.findByCompanyAndStatusAndLocation(company, status, location);

        }

        if((company!=null && !company.isBlank()) && (status!=null && !status.isBlank())){
            return repo.findByCompanyAndStatus(company,status);
        }
        if(status!=null && !status.isBlank()){
            return  repo.findByStatus(status);
        }
        if(location!=null && !location.isBlank()){
            return  repo.findByLocation(location);
        }
        if(company!=null && !company.isBlank()){
           return  repo.findByCompany(company);
        }
        return repo.findAll();
    }

    public JobApplication deleteApplication(int id) {
        JobApplication application=repo.findById(id).orElse(null);
        if(application!=null) {
             repo.delete(application);
             return application;
        }else{
            throw new ResourceNotFoundException("Application Not Found with id : "+id);

        }

    }

    public JobApplication updateApplication(int id,JobApplication application) {
        JobApplication a=repo.findById(id).orElse(null);
        if(a==null){
           throw new ResourceNotFoundException("Cannot Update.Application not found with id: "+ id);
        }
        a.setCompany(application.getCompany());
        a.setRole(application.getRole());
        a.setStatus(application.getStatus());
        a.setLocation(application.getLocation());
        a.setApplicationdate(application.getApplicationdate());
        return repo.save(a);
    }
}
