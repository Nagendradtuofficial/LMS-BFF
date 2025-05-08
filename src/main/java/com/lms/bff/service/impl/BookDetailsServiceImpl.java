package com.lms.bff.service.impl;

import com.lms.bff.entity.BookEntity;
import com.lms.bff.repository.BookDetailsRepo;
import com.lms.bff.service.BookDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BookDetailsServiceImpl implements BookDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(BookDetailsServiceImpl.class);

    @Autowired
    BookDetailsRepo bookDetailsRepo;

    @Autowired
    public BookDetailsServiceImpl(BookDetailsRepo bookDetailsRepo) {
        this.bookDetailsRepo = bookDetailsRepo;
    }

    public Flux<BookEntity> getAllBooks() {
        return bookDetailsRepo.findAll()
                .onErrorResume(error -> {
                    logger.error("Error fetching all books: ", error);
                    return Flux.empty();
                });
    }

    public Mono<String> addNewBook(BookEntity book) {

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            return Mono.just("Title is required");
        }
        if (book.getDescription() == null || book.getDescription().trim().isEmpty()) {
            return Mono.just("Description is required");
        }
        if (book.getQuantity() == null || book.getQuantity() < 0) {
            return Mono.just("Valid quantity is required");
        }

        Integer respId = book.getBookId();

        if (respId == null) {
            return bookDetailsRepo.save(book)
                    .thenReturn("New Book Added")
                    .onErrorResume(error -> {
                        logger.error("Error adding new book: ", error);
                        return Mono.just("Database Error: " + error.getMessage());
                    });
        } else {
            return bookDetailsRepo.findById(respId)
                    .flatMap(existingBook ->
                            bookDetailsRepo.save(book)
                                    .thenReturn("Existing Book's Data updated")
                    )
                    .switchIfEmpty(Mono.just("Book Id is invalid"))
                    .onErrorResume(error -> {
                        logger.error("Error updating book: ", error);
                        return Mono.just("Database Error: " + error.getMessage());
                    });
        }
    }

    public Mono<String> deleteBookById(Integer bookId) {
        return bookDetailsRepo.deleteById(bookId)
                .thenReturn("Book deleted")
                .onErrorResume(error -> {
                    logger.error("Error deleting book: ", error);
                    return Mono.just("Database Error: " + error.getMessage());
                });
    }
}