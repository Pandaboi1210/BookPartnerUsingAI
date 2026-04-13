package com.sprint.BookPartnerApplication.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "discounts")
public class Discount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long discountId;
    
    @ManyToOne
    @JoinColumn(name = "stor_id", nullable = false)
    private Store store;
    
    @Column(name = "lowqty")
    private Integer lowqty;
    
    @Column(name = "highqty")
    private Integer highqty;
    
    @Column(name = "discount")
    private BigDecimal discount;
    
    // Constructors
    public Discount() {}
    
    public Discount(Store store, Integer lowqty, Integer highqty, BigDecimal discount) {
        this.store = store;
        this.lowqty = lowqty;
        this.highqty = highqty;
        this.discount = discount;
    }
    
    // Getters and Setters
    public Long getDiscountId() {
        return discountId;
    }
    
    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }
    
    public Store getStore() {
        return store;
    }
    
    public void setStore(Store store) {
        this.store = store;
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
}
