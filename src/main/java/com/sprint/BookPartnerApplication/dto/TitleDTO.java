package com.sprint.BookPartnerApplication.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TitleDTO {
    
    private String titleId;
    private String title;
    private String type;
    private String publisherId;
    private BigDecimal price;
    private BigDecimal advance;
    private Integer royalty;
    private Integer ytdSales;
    private String notes;
    private LocalDate pubdate;
    
    // Constructors
    public TitleDTO() {}
    
    public TitleDTO(String titleId, String title, String type, String publisherId, 
                    BigDecimal price, BigDecimal advance, Integer royalty, String notes, LocalDate pubdate) {
        this.titleId = titleId;
        this.title = title;
        this.type = type;
        this.publisherId = publisherId;
        this.price = price;
        this.advance = advance;
        this.royalty = royalty;
        this.notes = notes;
        this.pubdate = pubdate;
    }
    
    // Getters and Setters
    public String getTitleId() {
        return titleId;
    }
    
    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getPublisherId() {
        return publisherId;
    }
    
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public BigDecimal getAdvance() {
        return advance;
    }
    
    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }
    
    public Integer getRoyalty() {
        return royalty;
    }
    
    public void setRoyalty(Integer royalty) {
        this.royalty = royalty;
    }
    
    public Integer getYtdSales() {
        return ytdSales;
    }
    
    public void setYtdSales(Integer ytdSales) {
        this.ytdSales = ytdSales;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public LocalDate getPubdate() {
        return pubdate;
    }
    
    public void setPubdate(LocalDate pubdate) {
        this.pubdate = pubdate;
    }
}
