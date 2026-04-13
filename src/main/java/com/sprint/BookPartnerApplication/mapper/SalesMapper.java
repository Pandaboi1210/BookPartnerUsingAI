package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.SalesDTO;
import com.sprint.BookPartnerApplication.entity.Sales;
import com.sprint.BookPartnerApplication.repository.StoreRepository;
import com.sprint.BookPartnerApplication.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesMapper {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private TitleRepository titleRepository;
    
    public SalesDTO toDTO(Sales sales) {
        if (sales == null) {
            return null;
        }
        return new SalesDTO(
            sales.getId(),
            sales.getStore() != null ? sales.getStore().getStorId() : null,
            sales.getOrdNum(),
            sales.getOrdDate(),
            sales.getQty(),
            sales.getPayterms(),
            sales.getTitle() != null ? sales.getTitle().getTitleId() : null
        );
    }
    
    public Sales toEntity(SalesDTO dto) {
        if (dto == null) {
            return null;
        }
        Sales sales = new Sales();
        sales.setId(dto.getId());
        if (dto.getStoreId() != null) {
            sales.setStore(storeRepository.findById(dto.getStoreId()).orElse(null));
        }
        sales.setOrdNum(dto.getOrdNum());
        sales.setOrdDate(dto.getOrdDate());
        sales.setQty(dto.getQty());
        sales.setPayterms(dto.getPayterms());
        if (dto.getTitleId() != null) {
            sales.setTitle(titleRepository.findById(dto.getTitleId()).orElse(null));
        }
        return sales;
    }
}
