package com.sprint.BookPartnerApplication.controller;

import com.sprint.BookPartnerApplication.dto.RoyschedDTO;
import com.sprint.BookPartnerApplication.entity.Roysched;
import com.sprint.BookPartnerApplication.service.RoyschedService;
import com.sprint.BookPartnerApplication.mapper.RoyschedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/royschedules")
public class RoyschedController {
    
    @Autowired
    private RoyschedService royschedService;
    
    @Autowired
    private RoyschedMapper royschedMapper;
    
    @GetMapping
    public ResponseEntity<List<RoyschedDTO>> getAllRoyschedules() {
        List<RoyschedDTO> royschedules = royschedService.getAllRoyschedules().stream()
                .map(royschedMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(royschedules, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RoyschedDTO> getRoyschedById(@PathVariable Long id) {
        Optional<Roysched> roysched = royschedService.getRoyschedById(id);
        return roysched.map(value -> new ResponseEntity<>(royschedMapper.toDTO(value), HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<RoyschedDTO> createRoysched(@RequestBody RoyschedDTO royschedDTO) {
        Roysched roysched = royschedMapper.toEntity(royschedDTO);
        Roysched savedRoysched = royschedService.saveRoysched(roysched);
        return new ResponseEntity<>(royschedMapper.toDTO(savedRoysched), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RoyschedDTO> updateRoysched(@PathVariable Long id, @RequestBody RoyschedDTO royschedDTO) {
        Optional<Roysched> existingRoysched = royschedService.getRoyschedById(id);
        if (existingRoysched.isPresent()) {
            Roysched roysched = royschedMapper.toEntity(royschedDTO);
            roysched.setRoyschedId(id);
            Roysched updatedRoysched = royschedService.saveRoysched(roysched);
            return new ResponseEntity<>(royschedMapper.toDTO(updatedRoysched), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoysched(@PathVariable Long id) {
        if (royschedService.getRoyschedById(id).isPresent()) {
            royschedService.deleteRoysched(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
