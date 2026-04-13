package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.DiscountDTO;
import com.sprint.BookPartnerApplication.entity.Discount;
import com.sprint.BookPartnerApplication.service.DiscountService;
import com.sprint.BookPartnerApplication.mapper.DiscountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
    
    @Autowired
    private DiscountService discountService;
    
    @Autowired
    private DiscountMapper discountMapper;
    
    @GetMapping
    public ResponseEntity<List<DiscountDTO>> getAllDiscounts() {
        List<DiscountDTO> discounts = discountService.getAllDiscounts().stream()
                .map(discountMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DiscountDTO> getDiscountById(@PathVariable Long id) {
        Optional<Discount> discount = discountService.getDiscountById(id);
        return discount.map(value -> new ResponseEntity<>(discountMapper.toDTO(value), HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<DiscountDTO> createDiscount(@RequestBody DiscountDTO discountDTO) {
        Discount discount = discountMapper.toEntity(discountDTO);
        Discount savedDiscount = discountService.saveDiscount(discount);
        return new ResponseEntity<>(discountMapper.toDTO(savedDiscount), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DiscountDTO> updateDiscount(@PathVariable Long id, @RequestBody DiscountDTO discountDTO) {
        Optional<Discount> existingDiscount = discountService.getDiscountById(id);
        if (existingDiscount.isPresent()) {
            Discount discount = discountMapper.toEntity(discountDTO);
            discount.setDiscountId(id);
            Discount updatedDiscount = discountService.saveDiscount(discount);
            return new ResponseEntity<>(discountMapper.toDTO(updatedDiscount), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        if (discountService.getDiscountById(id).isPresent()) {
            discountService.deleteDiscount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
