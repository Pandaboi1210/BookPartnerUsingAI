package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    
    @Id
    @Column(name = "au_id")
    private String auId;
    
    @Column(name = "au_lname", nullable = false)
    private String auLname;
    
    @Column(name = "au_fname", nullable = false)
    private String auFname;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "zip")
    private String zip;
    
    @Column(name = "contract")
    private Boolean contract;
    
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TitleAuthor> titleAuthors;
    
    // Constructors
    public Author() {}
    
    public Author(String auId, String auLname, String auFname, String phone, String address, 
                  String city, String state, String zip, Boolean contract) {
        this.auId = auId;
        this.auLname = auLname;
        this.auFname = auFname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contract = contract;
    }
    
    // Getters and Setters
    public String getAuId() {
        return auId;
    }
    
    public void setAuId(String auId) {
        this.auId = auId;
    }
    
    public String getAuLname() {
        return auLname;
    }
    
    public void setAuLname(String auLname) {
        this.auLname = auLname;
    }
    
    public String getAuFname() {
        return auFname;
    }
    
    public void setAuFname(String auFname) {
        this.auFname = auFname;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
    
    public Boolean getContract() {
        return contract;
    }
    
    public void setContract(Boolean contract) {
        this.contract = contract;
    }
    
    public List<TitleAuthor> getTitleAuthors() {
        return titleAuthors;
    }
    
    public void setTitleAuthors(List<TitleAuthor> titleAuthors) {
        this.titleAuthors = titleAuthors;
    }
}
