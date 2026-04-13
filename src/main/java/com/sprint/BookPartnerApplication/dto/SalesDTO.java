package com.sprint.BookPartnerApplication.dto;

import java.time.LocalDate;

public class SalesDTO {
    
    private Long id;
    private String storeId;
    private String ordNum;
    private LocalDate ordDate;
    private Integer qty;
    private String payterms;
    private String titleId;
    
    // Constructors
    public SalesDTO() {}
    
    public SalesDTO(Long id, String storeId, String ordNum, LocalDate ordDate, Integer qty, String payterms, String titleId) {
        this.id = id;
        this.storeId = storeId;
        this.ordNum = ordNum;
        this.ordDate = ordDate;
        this.qty = qty;
        this.payterms = payterms;
        this.titleId = titleId;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStoreId() {
        return storeId;
    }
    
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    
    public String getOrdNum() {
        return ordNum;
    }
    
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }
    
    public LocalDate getOrdDate() {
        return ordDate;
    }
    
    public void setOrdDate(LocalDate ordDate) {
        this.ordDate = ordDate;
    }
    
    public Integer getQty() {
        return qty;
    }
    
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    public String getPayterms() {
        return payterms;
    }
    
    public void setPayterms(String payterms) {
        this.payterms = payterms;
    }
    
    public String getTitleId() {
        return titleId;
    }
    
    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
}
