package com.sprint.BookPartnerApplication.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    
    private String empId;
    private String fname;
    private String minit;
    private String lname;
    private Integer jobLvl;
    private Integer jobId;
    private String pubId;
    private LocalDate hireDate;
    
    // Constructors
    public EmployeeDTO() {}
    
    public EmployeeDTO(String empId, String fname, String minit, String lname, Integer jobLvl, 
                       Integer jobId, String pubId, LocalDate hireDate) {
        this.empId = empId;
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.jobLvl = jobLvl;
        this.jobId = jobId;
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
    
    public Integer getJobId() {
        return jobId;
    }
    
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    
    public String getPubId() {
        return pubId;
    }
    
    public void setPubId(String pubId) {
        this.pubId = pubId;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
