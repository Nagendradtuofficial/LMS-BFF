package com.lms.bff.service;

import com.lms.bff.entity.BookEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface BookDetailsService {
    public Mono<ResponseEntity<Object>> getAllBooks();
    public Mono<ResponseEntity<Object>> addNewBook(BookEntity book);
}
