package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    
    @Id
    @Column(name = "job_id")
    private Integer jobId;
    
    @Column(name = "job_desc", nullable = false)
    private String jobDesc;
    
    @Column(name = "min_lvl")
    private Integer minLvl;
    
    @Column(name = "max_lvl")
    private Integer maxLvl;
    
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    
    // Constructors
    public Job() {}
    
    public Job(Integer jobId, String jobDesc, Integer minLvl, Integer maxLvl) {
        this.jobId = jobId;
        this.jobDesc = jobDesc;
        this.minLvl = minLvl;
        this.maxLvl = maxLvl;
    }
    
    // Getters and Setters
    public Integer getJobId() {
        return jobId;
    }
    
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    
    public String getJobDesc() {
        return jobDesc;
    }
    
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
    
    public Integer getMinLvl() {
        return minLvl;
    }
    
    public void setMinLvl(Integer minLvl) {
        this.minLvl = minLvl;
    }
    
    public Integer getMaxLvl() {
        return maxLvl;
    }
    
    public void setMaxLvl(Integer maxLvl) {
        this.maxLvl = maxLvl;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
