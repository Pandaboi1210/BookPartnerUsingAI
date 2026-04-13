package com.sprint.BookPartnerApplication.mapper;

import com.sprint.BookPartnerApplication.dto.AuthorDTO;
import com.sprint.BookPartnerApplication.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    
    public AuthorDTO toDTO(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorDTO(
            author.getAuId(),
            author.getAuLname(),
            author.getAuFname(),
            author.getPhone(),
            author.getAddress(),
            author.getCity(),
            author.getState(),
            author.getZip(),
            author.getContract()
        );
    }
    
    public Author toEntity(AuthorDTO dto) {
        if (dto == null) {
            return null;
        }
        Author author = new Author();
        author.setAuId(dto.getAuId());
        author.setAuLname(dto.getAuLname());
        author.setAuFname(dto.getAuFname());
        author.setPhone(dto.getPhone());
        author.setAddress(dto.getAddress());
        author.setCity(dto.getCity());
        author.setState(dto.getState());
        author.setZip(dto.getZip());
        author.setContract(dto.getContract());
        return author;
    }
}
