package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.AuthorDTO;
import com.sprint.BookPartnerApplication.entity.Author;
import com.sprint.BookPartnerApplication.service.AuthorService;
import com.sprint.BookPartnerApplication.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private AuthorMapper authorMapper;
    
    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> authors = authorService.getAllAuthors().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable String id) {
        Optional<Author> author = authorService.getAuthorById(id);
        return author.map(value -> new ResponseEntity<>(authorMapper.toDTO(value), HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        Author savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(authorMapper.toDTO(savedAuthor), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable String id, @RequestBody AuthorDTO authorDTO) {
        Optional<Author> existingAuthor = authorService.getAuthorById(id);
        if (existingAuthor.isPresent()) {
            Author author = authorMapper.toEntity(authorDTO);
            author.setAuId(id);
            Author updatedAuthor = authorService.saveAuthor(author);
            return new ResponseEntity<>(authorMapper.toDTO(updatedAuthor), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String id) {
        if (authorService.getAuthorById(id).isPresent()) {
            authorService.deleteAuthor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
