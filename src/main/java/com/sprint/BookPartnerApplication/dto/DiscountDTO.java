package com.sprint.BookPartnerApplication.dto;

import java.math.BigDecimal;

public class DiscountDTO {
    
    private Long discountId;
    private String storeId;
    private Integer lowqty;
    private Integer highqty;
    private BigDecimal discount;
    private String discounttype;
    
    // Constructors
    public DiscountDTO() {}
    
    public DiscountDTO(Long discountId, String storeId, Integer lowqty, Integer highqty, BigDecimal discount, String discounttype) {
        this.discountId = discountId;
        this.storeId = storeId;
        this.lowqty = lowqty;
        this.highqty = highqty;
        this.discount = discount;
        this.discounttype = discounttype;
    }
    
    // Getters and Setters
    public Long getDiscountId() {
        return discountId;
    }
    
    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }
    
    public String getStoreId() {
        return storeId;
    }
    
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    
    public Integer getLowqty() {
        return lowqty;
    }
    
    public void setLowqty(Integer lowqty) {
        this.lowqty = lowqty;
    }
    
    public Integer getHighqty() {
        return highqty;
    }
    
    public void setHighqty(Integer highqty) {
        this.highqty = highqty;
    }
    
    public BigDecimal getDiscount() {
        return discount;
    }
    
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    
    public String getDiscounttype() {
        return discounttype;
    }
    
    public void setDiscounttype(String discounttype) {
        this.discounttype = discounttype;
    }
}
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
