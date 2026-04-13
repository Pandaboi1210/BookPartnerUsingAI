package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.RoyschedDTO;
import com.sprint.BookPartnerApplication.entity.Roysched;
import com.sprint.BookPartnerApplication.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoyschedMapper {
    
    @Autowired
    private TitleRepository titleRepository;
    
    public RoyschedDTO toDTO(Roysched roysched) {
        if (roysched == null) {
            return null;
        }
        return new RoyschedDTO(
            roysched.getRoyschedId(),
            roysched.getTitle() != null ? roysched.getTitle().getTitleId() : null,
            roysched.getLorange(),
            roysched.getHirange(),
            roysched.getRoyalty()
        );
    }
    
    public Roysched toEntity(RoyschedDTO dto) {
        if (dto == null) {
            return null;
        }
        Roysched roysched = new Roysched();
        roysched.setRoyschedId(dto.getRoyschedId());
        if (dto.getTitleId() != null) {
            roysched.setTitle(titleRepository.findById(dto.getTitleId()).orElse(null));
        }
        roysched.setLorange(dto.getLorange());
        roysched.setHirange(dto.getHirange());
        roysched.setRoyalty(dto.getRoyalty());
        return roysched;
    }
}
