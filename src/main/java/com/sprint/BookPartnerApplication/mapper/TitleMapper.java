package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.TitleDTO;
import com.sprint.BookPartnerApplication.entity.Title;
import com.sprint.BookPartnerApplication.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {
    
    @Autowired
    private PublisherRepository publisherRepository;
    
    public TitleDTO toDTO(Title title) {
        if (title == null) {
            return null;
        }
        return new TitleDTO(
            title.getTitleId(),
            title.getTitle(),
            title.getType(),
            title.getPublisher() != null ? title.getPublisher().getPubId() : null,
            title.getPrice(),
            title.getAdvance(),
            title.getRoyalty(),
            title.getNotes(),
            title.getPubdate()
        );
    }
    
    public Title toEntity(TitleDTO dto) {
        if (dto == null) {
            return null;
        }
        Title title = new Title();
        title.setTitleId(dto.getTitleId());
        title.setTitle(dto.getTitle());
        title.setType(dto.getType());
        if (dto.getPublisherId() != null) {
            title.setPublisher(publisherRepository.findById(dto.getPublisherId()).orElse(null));
        }
        title.setPrice(dto.getPrice());
        title.setAdvance(dto.getAdvance());
        title.setRoyalty(dto.getRoyalty());
        title.setNotes(dto.getNotes());
        title.setPubdate(dto.getPubdate());
        return title;
    }
}
