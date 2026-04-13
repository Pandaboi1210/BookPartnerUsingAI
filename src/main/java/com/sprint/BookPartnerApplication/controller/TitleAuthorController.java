package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.TitleAuthorDTO;
import com.sprint.BookPartnerApplication.entity.TitleAuthor;
import com.sprint.BookPartnerApplication.service.TitleAuthorService;
import com.sprint.BookPartnerApplication.mapper.TitleAuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/title-authors")
public class TitleAuthorController {
    
    @Autowired
    private TitleAuthorService titleAuthorService;
    
    @Autowired
    private TitleAuthorMapper titleAuthorMapper;
    
    @GetMapping
    public ResponseEntity<List<TitleAuthorDTO>> getAllTitleAuthors() {
        List<TitleAuthorDTO> titleAuthors = titleAuthorService.getAllTitleAuthors().stream()
                .map(titleAuthorMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(titleAuthors, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TitleAuthorDTO> getTitleAuthorById(@PathVariable Long id) {
        Optional<TitleAuthor> titleAuthor = titleAuthorService.getTitleAuthorById(id);
        return titleAuthor.map(value -> new ResponseEntity<>(titleAuthorMapper.toDTO(value), HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<TitleAuthorDTO> createTitleAuthor(@RequestBody TitleAuthorDTO titleAuthorDTO) {
        TitleAuthor titleAuthor = titleAuthorMapper.toEntity(titleAuthorDTO);
        TitleAuthor savedTitleAuthor = titleAuthorService.saveTitleAuthor(titleAuthor);
        return new ResponseEntity<>(titleAuthorMapper.toDTO(savedTitleAuthor), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TitleAuthorDTO> updateTitleAuthor(@PathVariable Long id, @RequestBody TitleAuthorDTO titleAuthorDTO) {
        Optional<TitleAuthor> existingTitleAuthor = titleAuthorService.getTitleAuthorById(id);
        if (existingTitleAuthor.isPresent()) {
            TitleAuthor titleAuthor = titleAuthorMapper.toEntity(titleAuthorDTO);
            titleAuthor.setId(id);
            TitleAuthor updatedTitleAuthor = titleAuthorService.saveTitleAuthor(titleAuthor);
            return new ResponseEntity<>(titleAuthorMapper.toDTO(updatedTitleAuthor), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitleAuthor(@PathVariable Long id) {
        if (titleAuthorService.getTitleAuthorById(id).isPresent()) {
            titleAuthorService.deleteTitleAuthor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
