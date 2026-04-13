package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.StoreDTO;
import com.sprint.BookPartnerApplication.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    
    public StoreDTO toDTO(Store store) {
        if (store == null) {
            return null;
        }
        return new StoreDTO(
            store.getStorId(),
            store.getStorName(),
            store.getStorAddress(),
            store.getCity(),
            store.getState(),
            store.getZip()
        );
    }
    
    public Store toEntity(StoreDTO dto) {
        if (dto == null) {
            return null;
        }
        Store store = new Store();
        store.setStorId(dto.getStorId());
        store.setStorName(dto.getStorName());
        store.setStorAddress(dto.getStorAddress());
        store.setCity(dto.getCity());
        store.setState(dto.getState());
        store.setZip(dto.getZip());
        return store;
    }
}
