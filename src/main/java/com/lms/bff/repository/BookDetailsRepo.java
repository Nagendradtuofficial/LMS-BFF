package com.lms.bff.repository;

import com.lms.bff.entity.BookEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookDetailsRepo extends ReactiveCrudRepository<BookEntity, Integer> {
}
