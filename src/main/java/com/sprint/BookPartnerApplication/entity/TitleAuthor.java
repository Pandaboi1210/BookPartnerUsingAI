package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "titleauthor")
public class TitleAuthor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "au_id", nullable = false)
    private Author author;
    
    @ManyToOne
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;
    
    @Column(name = "au_ord")
    private Integer auOrd;
    
    @Column(name = "royaltyper")
    private Integer royaltyper;
    
    // Constructors
    public TitleAuthor() {}
    
    public TitleAuthor(Author author, Title title, Integer auOrd, Integer royaltyper) {
        this.author = author;
        this.title = title;
        this.auOrd = auOrd;
        this.royaltyper = royaltyper;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Title getTitle() {
        return title;
    }
    
    public void setTitle(Title title) {
        this.title = title;
    }
    
    public Integer getAuOrd() {
        return auOrd;
    }
    
    public void setAuOrd(Integer auOrd) {
        this.auOrd = auOrd;
    }
    
    public Integer getRoyaltyper() {
        return royaltyper;
    }
    
    public void setRoyaltyper(Integer royaltyper) {
        this.royaltyper = royaltyper;
    }
}
