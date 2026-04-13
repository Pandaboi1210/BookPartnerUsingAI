package com.sprint.BookPartnerApplication.dto;

public class TitleAuthorDTO {
    
    private Long id;
    private String authorId;
    private String titleId;
    private Integer auOrd;
    private Integer royaltyper;
    
    // Constructors
    public TitleAuthorDTO() {}
    
    public TitleAuthorDTO(Long id, String authorId, String titleId, Integer auOrd, Integer royaltyper) {
        this.id = id;
        this.authorId = authorId;
        this.titleId = titleId;
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
    
    public String getAuthorId() {
        return authorId;
    }
    
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
    
    public String getTitleId() {
        return titleId;
    }
    
    public void setTitleId(String titleId) {
        this.titleId = titleId;
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
