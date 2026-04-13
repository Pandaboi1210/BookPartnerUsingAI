package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roysched")
public class Roysched {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roysched_id")
    private Long royschedId;
    
    @ManyToOne
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;
    
    @Column(name = "lorange")
    private Integer lorange;
    
    @Column(name = "hirange")
    private Integer hirange;
    
    @Column(name = "royalty")
    private Integer royalty;
    
    // Constructors
    public Roysched() {}
    
    public Roysched(Title title, Integer lorange, Integer hirange, Integer royalty) {
        this.title = title;
        this.lorange = lorange;
        this.hirange = hirange;
        this.royalty = royalty;
    }
    
    // Getters and Setters
    public Long getRoyschedId() {
        return royschedId;
    }
    
    public void setRoyschedId(Long royschedId) {
        this.royschedId = royschedId;
    }
    
    public Title getTitle() {
        return title;
    }
    
    public void setTitle(Title title) {
        this.title = title;
    }
    
    public Integer getLorange() {
        return lorange;
    }
    
    public void setLorange(Integer lorange) {
        this.lorange = lorange;
    }
    
    public Integer getHirange() {
        return hirange;
    }
    
    public void setHirange(Integer hirange) {
        this.hirange = hirange;
    }
    
    public Integer getRoyalty() {
        return royalty;
    }
    
    public void setRoyalty(Integer royalty) {
        this.royalty = royalty;
    }
}
