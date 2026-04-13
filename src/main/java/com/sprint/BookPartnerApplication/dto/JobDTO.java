package com.sprint.BookPartnerApplication.dto;

public class JobDTO {
    
    private Integer jobId;
    private String jobDesc;
    private Integer minLvl;
    private Integer maxLvl;
    
    // Constructors
    public JobDTO() {}
    
    public JobDTO(Integer jobId, String jobDesc, Integer minLvl, Integer maxLvl) {
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
}
