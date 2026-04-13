package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.Store;
import com.sprint.BookPartnerApplication.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    
    @Autowired
    private StoreRepository storeRepository;
    
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    
    public Optional<Store> getStoreById(String id) {
        return storeRepository.findById(id);
    }
    
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }
    
    public void deleteStore(String id) {
        storeRepository.deleteById(id);
    }
}
