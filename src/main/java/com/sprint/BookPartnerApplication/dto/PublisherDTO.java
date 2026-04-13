package com.sprint.BookPartnerApplication.dto;

public class PublisherDTO {
    
    private String pubId;
    private String pubName;
    private String city;
    private String state;
    private String country;
    
    // Constructors
    public PublisherDTO() {}
    
    public PublisherDTO(String pubId, String pubName, String city, String state, String country) {
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
}
