package com.lms.bff.service;

import com.lms.bff.entity.BookEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface BookDetailsService {
    public Flux<BookEntity> getAllBooks();
    public Mono<String> deleteBookById(Integer bookId);
    public Mono<String> addNewBook(BookEntity book);
}
