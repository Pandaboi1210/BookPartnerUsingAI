package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.Job;
import com.sprint.BookPartnerApplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepository;
    
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
    public Optional<Job> getJobById(Integer id) {
        return jobRepository.findById(id);
    }
    
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
    
    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }
}
