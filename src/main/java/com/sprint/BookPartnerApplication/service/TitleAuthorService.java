package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.TitleAuthor;
import com.sprint.BookPartnerApplication.repository.TitleAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TitleAuthorService {
    
    @Autowired
    private TitleAuthorRepository titleAuthorRepository;
    
    public List<TitleAuthor> getAllTitleAuthors() {
        return titleAuthorRepository.findAll();
    }
    
    public Optional<TitleAuthor> getTitleAuthorById(Long id) {
        return titleAuthorRepository.findById(id);
    }
    
    public TitleAuthor saveTitleAuthor(TitleAuthor titleAuthor) {
        return titleAuthorRepository.save(titleAuthor);
    }
    
    public void deleteTitleAuthor(Long id) {
        titleAuthorRepository.deleteById(id);
    }
}
