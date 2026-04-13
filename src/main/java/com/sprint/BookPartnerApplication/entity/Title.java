package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "titles")
public class Title {
    
    @Id
    @Column(name = "title_id")
    private String titleId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "type")
    private String type;
    
    @ManyToOne
    @JoinColumn(name = "pub_id", nullable = false)
    private Publisher publisher;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "advance")
    private BigDecimal advance;
    
    @Column(name = "royalty")
    private Integer royalty;
    
    @Column(name = "ytd_sales")
    private Integer ytdSales;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "pubdate")
    private LocalDate pubdate;
    
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TitleAuthor> titleAuthors;
    
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Roysched> royschedules;
    
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sales> sales;
    
    // Constructors
    public Title() {}
    
    public Title(String titleId, String title, String type, Publisher publisher, 
                 BigDecimal price, BigDecimal advance, Integer royalty, String notes, LocalDate pubdate) {
        this.titleId = titleId;
        this.title = title;
        this.type = type;
        this.publisher = publisher;
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
    
    public Publisher getPublisher() {
        return publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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
    
    public List<TitleAuthor> getTitleAuthors() {
        return titleAuthors;
    }
    
    public void setTitleAuthors(List<TitleAuthor> titleAuthors) {
        this.titleAuthors = titleAuthors;
    }
    
    public List<Roysched> getRoyschedules() {
        return royschedules;
    }
    
    public void setRoyschedules(List<Roysched> royschedules) {
        this.royschedules = royschedules;
    }
    
    public List<Sales> getSales() {
        return sales;
    }
    
    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
}
