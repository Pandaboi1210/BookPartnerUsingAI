package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.Publisher;
import com.sprint.BookPartnerApplication.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    
    @Autowired
    private PublisherRepository publisherRepository;
    
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
    
    public Optional<Publisher> getPublisherById(String id) {
        return publisherRepository.findById(id);
    }
    
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
    
    public void deletePublisher(String id) {
        publisherRepository.deleteById(id);
    }
}
