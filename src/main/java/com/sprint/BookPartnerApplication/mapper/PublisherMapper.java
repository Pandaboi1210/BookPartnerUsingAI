package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.PublisherDTO;
import com.sprint.BookPartnerApplication.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    
    public PublisherDTO toDTO(Publisher publisher) {
        if (publisher == null) {
            return null;
        }
        return new PublisherDTO(
            publisher.getPubId(),
            publisher.getPubName(),
            publisher.getCity(),
            publisher.getState(),
            publisher.getCountry()
        );
    }
    
    public Publisher toEntity(PublisherDTO dto) {
        if (dto == null) {
            return null;
        }
        Publisher publisher = new Publisher();
        publisher.setPubId(dto.getPubId());
        publisher.setPubName(dto.getPubName());
        publisher.setCity(dto.getCity());
        publisher.setState(dto.getState());
        publisher.setCountry(dto.getCountry());
        return publisher;
    }
}
