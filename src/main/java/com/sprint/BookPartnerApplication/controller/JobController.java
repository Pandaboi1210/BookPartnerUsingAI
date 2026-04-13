package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.JobDTO;
import com.sprint.BookPartnerApplication.entity.Job;
import com.sprint.BookPartnerApplication.service.JobService;
import com.sprint.BookPartnerApplication.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    @Autowired
    private JobMapper jobMapper;
    
    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<JobDTO> jobs = jobService.getAllJobs().stream()
                .map(jobMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Integer id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(value -> new ResponseEntity<>(jobMapper.toDTO(value), HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<JobDTO> createJob(@RequestBody JobDTO jobDTO) {
        Job job = jobMapper.toEntity(jobDTO);
        Job savedJob = jobService.saveJob(job);
        return new ResponseEntity<>(jobMapper.toDTO(savedJob), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Integer id, @RequestBody JobDTO jobDTO) {
        Optional<Job> existingJob = jobService.getJobById(id);
        if (existingJob.isPresent()) {
            Job job = jobMapper.toEntity(jobDTO);
            job.setJobId(id);
            Job updatedJob = jobService.saveJob(job);
            return new ResponseEntity<>(jobMapper.toDTO(updatedJob), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {
        if (jobService.getJobById(id).isPresent()) {
            jobService.deleteJob(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
