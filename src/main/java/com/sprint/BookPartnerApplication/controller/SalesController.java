package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.SalesDTO;
import com.sprint.BookPartnerApplication.entity.Sales;
import com.sprint.BookPartnerApplication.service.SalesService;
import com.sprint.BookPartnerApplication.mapper.SalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    
    @Autowired
    private SalesService salesService;
    
    @Autowired
    private SalesMapper salesMapper;
    
    @GetMapping
    public ResponseEntity<List<SalesDTO>> getAllSales() {
        List<SalesDTO> sales = salesService.getAllSales().stream()
                .map(salesMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SalesDTO> getSalesById(@PathVariable Long id) {
        Optional<Sales> sales = salesService.getSalesById(id);
        return sales.map(value -> new ResponseEntity<>(salesMapper.toDTO(value), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<SalesDTO> createSales(@RequestBody SalesDTO salesDTO) {
        Sales sales = salesMapper.toEntity(salesDTO);
        Sales savedSales = salesService.saveSales(sales);
        return new ResponseEntity<>(salesMapper.toDTO(savedSales), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SalesDTO> updateSales(@PathVariable Long id, @RequestBody SalesDTO salesDTO) {
        Optional<Sales> existingSales = salesService.getSalesById(id);
        if (existingSales.isPresent()) {
            Sales sales = salesMapper.toEntity(salesDTO);
            sales.setId(id);
            Sales updatedSales = salesService.saveSales(sales);
            return new ResponseEntity<>(salesMapper.toDTO(updatedSales), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable Long id) {
        if (salesService.getSalesById(id).isPresent()) {
            salesService.deleteSales(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
