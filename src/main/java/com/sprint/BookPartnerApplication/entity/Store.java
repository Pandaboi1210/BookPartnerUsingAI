package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {
    
    @Id
    @Column(name = "stor_id")
    private String storId;
    
    @Column(name = "stor_name", nullable = false)
    private String storName;
    
    @Column(name = "stor_address")
    private String storAddress;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "zip")
    private String zip;
    
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sales> sales;
    
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discount> discounts;
    
    // Constructors
    public Store() {}
    
    public Store(String storId, String storName, String storAddress, String city, String state, String zip) {
        this.storId = storId;
        this.storName = storName;
        this.storAddress = storAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    // Getters and Setters
    public String getStorId() {
        return storId;
    }
    
    public void setStorId(String storId) {
        this.storId = storId;
    }
    
    public String getStorName() {
        return storName;
    }
    
    public void setStorName(String storName) {
        this.storName = storName;
    }
    
    public String getStorAddress() {
        return storAddress;
    }
    
    public void setStorAddress(String storAddress) {
        this.storAddress = storAddress;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public List<Sales> getSales() {
        return sales;
    }
    
    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
    
    public List<Discount> getDiscounts() {
        return discounts;
    }
    
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
