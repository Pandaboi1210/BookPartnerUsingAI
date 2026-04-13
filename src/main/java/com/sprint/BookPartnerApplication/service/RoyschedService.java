package com.sprint.BookPartnerApplication.service;

import com.sprint.BookPartnerApplication.entity.Roysched;
import com.sprint.BookPartnerApplication.repository.RoyschedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoyschedService {
    
    @Autowired
    private RoyschedRepository royschedRepository;
    
    public List<Roysched> getAllRoyschedules() {
        return royschedRepository.findAll();
    }
    
    public Optional<Roysched> getRoyschedById(Long id) {
        return royschedRepository.findById(id);
    }
    
    public Roysched saveRoysched(Roysched roysched) {
        return royschedRepository.save(roysched);
    }
    
    public void deleteRoysched(Long id) {
        royschedRepository.deleteById(id);
    }
}
