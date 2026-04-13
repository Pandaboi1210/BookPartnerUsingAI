package com.sprint.BookPartnerApplication.repository;

import com.sprint.BookPartnerApplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
}
