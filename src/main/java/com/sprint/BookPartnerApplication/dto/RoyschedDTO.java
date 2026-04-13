package com.sprint.BookPartnerApplication.dto;

public class RoyschedDTO {
    
    private Long royschedId;
    private String titleId;
    private Integer lorange;
    private Integer hirange;
    private Integer royalty;
    
    // Constructors
    public RoyschedDTO() {}
    
    public RoyschedDTO(Long royschedId, String titleId, Integer lorange, Integer hirange, Integer royalty) {
        this.royschedId = royschedId;
        this.titleId = titleId;
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
    
    public String getTitleId() {
        return titleId;
    }
    
    public void setTitleId(String titleId) {
        this.titleId = titleId;
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
