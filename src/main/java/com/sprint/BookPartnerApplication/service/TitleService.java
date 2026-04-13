package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.Title;
import com.sprint.BookPartnerApplication.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TitleService {
    
    @Autowired
    private TitleRepository titleRepository;
    
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }
    
    public Optional<Title> getTitleById(String id) {
        return titleRepository.findById(id);
    }
    
    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }
    
    public void deleteTitle(String id) {
        titleRepository.deleteById(id);
    }
}
