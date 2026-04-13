package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.TitleAuthorDTO;
import com.sprint.BookPartnerApplication.entity.TitleAuthor;
import com.sprint.BookPartnerApplication.repository.AuthorRepository;
import com.sprint.BookPartnerApplication.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleAuthorMapper {
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private TitleRepository titleRepository;
    
    public TitleAuthorDTO toDTO(TitleAuthor titleAuthor) {
        if (titleAuthor == null) {
            return null;
        }
        return new TitleAuthorDTO(
            titleAuthor.getId(),
            titleAuthor.getAuthor() != null ? titleAuthor.getAuthor().getAuId() : null,
            titleAuthor.getTitle() != null ? titleAuthor.getTitle().getTitleId() : null,
            titleAuthor.getAuOrd(),
            titleAuthor.getRoyaltyper()
        );
    }
    
    public TitleAuthor toEntity(TitleAuthorDTO dto) {
        if (dto == null) {
            return null;
        }
        TitleAuthor titleAuthor = new TitleAuthor();
        titleAuthor.setId(dto.getId());
        if (dto.getAuthorId() != null) {
            titleAuthor.setAuthor(authorRepository.findById(dto.getAuthorId()).orElse(null));
        }
        if (dto.getTitleId() != null) {
            titleAuthor.setTitle(titleRepository.findById(dto.getTitleId()).orElse(null));
        }
        titleAuthor.setAuOrd(dto.getAuOrd());
        titleAuthor.setRoyaltyper(dto.getRoyaltyper());
        return titleAuthor;
    }
}
