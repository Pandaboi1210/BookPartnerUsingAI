package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.DiscountDTO;
import com.sprint.BookPartnerApplication.entity.Discount;
import com.sprint.BookPartnerApplication.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {
    
    @Autowired
    private StoreRepository storeRepository;
    
    public DiscountDTO toDTO(Discount discount) {
        if (discount == null) {
            return null;
        }
        return new DiscountDTO(
            discount.getDiscountId(),
            discount.getStore() != null ? discount.getStore().getStorId() : null,
            discount.getLowqty(),
            discount.getHighqty(),
            discount.getDiscount(),
            discount.getDiscounttype()
        );
    }
    
    public Discount toEntity(DiscountDTO dto) {
        if (dto == null) {
            return null;
        }
        Discount discount = new Discount();
        discount.setDiscountId(dto.getDiscountId());
        if (dto.getStoreId() != null) {
            discount.setStore(storeRepository.findById(dto.getStoreId()).orElse(null));
        }
        discount.setLowqty(dto.getLowqty());
        discount.setHighqty(dto.getHighqty());
        discount.setDiscount(dto.getDiscount());
        discount.setDiscounttype(dto.getDiscounttype());
        return discount;
    }
}
