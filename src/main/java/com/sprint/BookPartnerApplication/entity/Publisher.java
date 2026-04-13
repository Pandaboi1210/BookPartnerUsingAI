package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    
    @Id
    @Column(name = "pub_id")
    private String pubId;
    
    @Column(name = "pub_name", nullable = false)
    private String pubName;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;
    
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Title> titles;
    
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    
    // Constructors
    public Publisher() {}
    
    public Publisher(String pubId, String pubName, String city, String state, String country) {
        this.pubId = pubId;
        this.pubName = pubName;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    
    // Getters and Setters
    public String getPubId() {
        return pubId;
    }
    
    public void setPubId(String pubId) {
        this.pubId = pubId;
    }
    
    public String getPubName() {
        return pubName;
    }
    
    public void setPubName(String pubName) {
        this.pubName = pubName;
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
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public List<Title> getTitles() {
        return titles;
    }
    
    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
