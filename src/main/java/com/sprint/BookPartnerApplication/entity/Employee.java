package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    
    @Id
    @Column(name = "emp_id")
    private String empId;
    
    @Column(name = "fname", nullable = false)
    private String fname;
    
    @Column(name = "minit")
    private String minit;
    
    @Column(name = "lname", nullable = false)
    private String lname;
    
    @Column(name = "job_lvl")
    private Integer jobLvl;
    
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    
    @Column(name = "pub_id")
    private String pubId;
    
    @ManyToOne
    @JoinColumn(name = "pub_id", insertable = false, updatable = false)
    private Publisher publisher;
    
    @Column(name = "hire_date")
    private LocalDate hireDate;
    
    // Constructors
    public Employee() {}
    
    public Employee(String empId, String fname, String minit, String lname, Integer jobLvl, 
                    Job job, String pubId, LocalDate hireDate) {
        this.empId = empId;
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.jobLvl = jobLvl;
        this.job = job;
        this.pubId = pubId;
        this.hireDate = hireDate;
    }
    
    // Getters and Setters
    public String getEmpId() {
        return empId;
    }
    
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    
    public String getFname() {
        return fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getMinit() {
        return minit;
    }
    
    public void setMinit(String minit) {
        this.minit = minit;
    }
    
    public String getLname() {
        return lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public Integer getJobLvl() {
        return jobLvl;
    }
    
    public void setJobLvl(Integer jobLvl) {
        this.jobLvl = jobLvl;
    }
    
    public Job getJob() {
        return job;
    }
    
    public void setJob(Job job) {
        this.job = job;
    }
    
    public String getPubId() {
        return pubId;
    }
    
    public void setPubId(String pubId) {
        this.pubId = pubId;
    }
    
    public Publisher getPublisher() {
        return publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
