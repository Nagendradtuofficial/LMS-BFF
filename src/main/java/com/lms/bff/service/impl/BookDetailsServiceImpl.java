package com.lms.bff.service.impl;

import com.lms.bff.entity.BookEntity;
import com.lms.bff.repository.BookDetailsRepo;
import com.lms.bff.service.BookDetailsService;
import com.lms.bff.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

    @Autowired
    public BookDetailsServiceImpl(BookDetailsRepo bookDetailsRepo) {
        this.bookDetailsRepo = bookDetailsRepo;
    }

    @Autowired
    BookDetailsRepo bookDetailsRepo;

    public Mono<ResponseEntity<Object>> getAllBooks() {
        Flux<BookEntity> responseBooksList = bookDetailsRepo.findAll();

        ResponseEntity<Object> response = ResponseHandler.responseBuilder("All books fetched", HttpStatus.OK, responseBooksList);
        return Mono.just(response);
    }

    public Mono<ResponseEntity<Object>> addNewBook(BookEntity book) {
        Integer respId = book.getBookId();

        bookDetailsRepo.save(book);
        ResponseEntity<Object> response = ResponseHandler.responseBuilder("New Book Added", HttpStatus.OK);
        return Mono.just(response);
    }

    public Mono<ResponseEntity<Object>> deleteBookById(Integer bookId) {
        bookDetailsRepo.deleteById(bookId);
        ResponseEntity<Object> response = ResponseHandler.responseBuilder("Book deleted successfully", HttpStatus.OK);
        return Mono.just(response);
    }
}
