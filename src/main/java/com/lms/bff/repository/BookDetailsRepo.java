package com.lms.bff.repository;

import com.lms.bff.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsRepo extends JpaRepository<BookEntity, Integer> {
}
