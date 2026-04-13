package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.TitleDTO;
import com.sprint.BookPartnerApplication.entity.Title;
import com.sprint.BookPartnerApplication.service.TitleService;
import com.sprint.BookPartnerApplication.mapper.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/titles")
public class TitleController {
    
    @Autowired
    private TitleService titleService;
    
    @Autowired
    private TitleMapper titleMapper;
    
    @GetMapping
    public ResponseEntity<List<TitleDTO>> getAllTitles() {
        List<TitleDTO> titles = titleService.getAllTitles().stream()
                .map(titleMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TitleDTO> getTitleById(@PathVariable String id) {
        Optional<Title> title = titleService.getTitleById(id);
        return title.map(value -> new ResponseEntity<>(titleMapper.toDTO(value), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<TitleDTO> createTitle(@RequestBody TitleDTO titleDTO) {
        Title title = titleMapper.toEntity(titleDTO);
        Title savedTitle = titleService.saveTitle(title);
        return new ResponseEntity<>(titleMapper.toDTO(savedTitle), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TitleDTO> updateTitle(@PathVariable String id, @RequestBody TitleDTO titleDTO) {
        Optional<Title> existingTitle = titleService.getTitleById(id);
        if (existingTitle.isPresent()) {
            Title title = titleMapper.toEntity(titleDTO);
            title.setTitleId(id);
            Title updatedTitle = titleService.saveTitle(title);
            return new ResponseEntity<>(titleMapper.toDTO(updatedTitle), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitle(@PathVariable String id) {
        if (titleService.getTitleById(id).isPresent()) {
            titleService.deleteTitle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
