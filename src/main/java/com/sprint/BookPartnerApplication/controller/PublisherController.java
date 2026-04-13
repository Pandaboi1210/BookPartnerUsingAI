package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.PublisherDTO;
import com.sprint.BookPartnerApplication.entity.Publisher;
import com.sprint.BookPartnerApplication.service.PublisherService;
import com.sprint.BookPartnerApplication.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    
    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private PublisherMapper publisherMapper;
    
    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        List<PublisherDTO> publishers = publisherService.getAllPublishers().stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable String id) {
        Optional<Publisher> publisher = publisherService.getPublisherById(id);
        return publisher.map(value -> new ResponseEntity<>(publisherMapper.toDTO(value), HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO publisherDTO) {
        Publisher publisher = publisherMapper.toEntity(publisherDTO);
        Publisher savedPublisher = publisherService.savePublisher(publisher);
        return new ResponseEntity<>(publisherMapper.toDTO(savedPublisher), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable String id, @RequestBody PublisherDTO publisherDTO) {
        Optional<Publisher> existingPublisher = publisherService.getPublisherById(id);
        if (existingPublisher.isPresent()) {
            Publisher publisher = publisherMapper.toEntity(publisherDTO);
            publisher.setPubId(id);
            Publisher updatedPublisher = publisherService.savePublisher(publisher);
            return new ResponseEntity<>(publisherMapper.toDTO(updatedPublisher), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable String id) {
        if (publisherService.getPublisherById(id).isPresent()) {
            publisherService.deletePublisher(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
