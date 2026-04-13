package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "stor_id", nullable = false)
    private Store store;
    
    @Column(name = "ord_num", nullable = false)
    private String ordNum;
    
    @Column(name = "ord_date")
    private LocalDate ordDate;
    
    @Column(name = "qty")
    private Integer qty;
    
    @Column(name = "payterms")
    private String payterms;
    
    @ManyToOne
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;
    
    // Constructors
    public Sales() {}
    
    public Sales(Store store, String ordNum, LocalDate ordDate, Integer qty, String payterms, Title title) {
        this.store = store;
        this.ordNum = ordNum;
        this.ordDate = ordDate;
        this.qty = qty;
        this.payterms = payterms;
        this.title = title;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Store getStore() {
        return store;
    }
    
    public void setStore(Store store) {
        this.store = store;
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
    
    public Title getTitle() {
        return title;
    }
    
    public void setTitle(Title title) {
        this.title = title;
    }
}
