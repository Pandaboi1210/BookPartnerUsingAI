package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.Author;
import com.sprint.BookPartnerApplication.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;
    
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    
    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }
    
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
    
    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }
}
