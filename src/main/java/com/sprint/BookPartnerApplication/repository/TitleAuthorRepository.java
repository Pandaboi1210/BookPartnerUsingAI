package com.sprint.BookPartnerApplication.repository;

import com.sprint.BookPartnerApplication.entity.TitleAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleAuthorRepository extends JpaRepository<TitleAuthor, Long> {
}
