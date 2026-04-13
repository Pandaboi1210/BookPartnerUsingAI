package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.StoreDTO;
import com.sprint.BookPartnerApplication.entity.Store;
import com.sprint.BookPartnerApplication.service.StoreService;
import com.sprint.BookPartnerApplication.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    
    @Autowired
    private StoreService storeService;
    
    @Autowired
    private StoreMapper storeMapper;
    
    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<StoreDTO> stores = storeService.getAllStores().stream()
                .map(storeMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable String id) {
        Optional<Store> store = storeService.getStoreById(id);
        return store.map(value -> new ResponseEntity<>(storeMapper.toDTO(value), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO) {
        Store store = storeMapper.toEntity(storeDTO);
        Store savedStore = storeService.saveStore(store);
        return new ResponseEntity<>(storeMapper.toDTO(savedStore), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(@PathVariable String id, @RequestBody StoreDTO storeDTO) {
        Optional<Store> existingStore = storeService.getStoreById(id);
        if (existingStore.isPresent()) {
            Store store = storeMapper.toEntity(storeDTO);
            store.setStorId(id);
            Store updatedStore = storeService.saveStore(store);
            return new ResponseEntity<>(storeMapper.toDTO(updatedStore), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable String id) {
        if (storeService.getStoreById(id).isPresent()) {
            storeService.deleteStore(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
