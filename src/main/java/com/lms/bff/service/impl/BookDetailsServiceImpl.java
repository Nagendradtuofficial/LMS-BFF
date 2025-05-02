package com.lms.bff.service.impl;

import com.lms.bff.entity.BookEntity;
import com.lms.bff.repository.BookDetailsRepo;
import com.lms.bff.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsServiceImpl {

    @Autowired
    BookDetailsRepo bookDetailsRepo;

    public Mono<ResponseEntity<Object>> getAllBooks() {
        List<BookEntity> resposeBooksList = bookDetailsRepo.findAll();

        ResponseEntity<Object> response = ResponseHandler.responseBuilder("All books fetched", HttpStatus.OK, resposeBooksList);
        return Mono.just(response);
    }

    public Mono<ResponseEntity<Object>> addNewBook(BookEntity book) {
        Integer respId = book.getBookId();

        if(respId == null){
            bookDetailsRepo.save(book);
            ResponseEntity<Object> response = ResponseHandler.responseBuilder("New Book Added", HttpStatus.OK);
            return Mono.just(response);
        }else{
            Optional<BookEntity> reqBook = bookDetailsRepo.findById(respId);
            if(reqBook.isEmpty()){
                ResponseEntity<Object> response = ResponseHandler.responseBuilder("Book Id is invalid", HttpStatus.NOT_ACCEPTABLE);
                return Mono.just(response);
            }
            bookDetailsRepo.save(book);
            ResponseEntity<Object> response = ResponseHandler.responseBuilder("Existing Book's Data updated", HttpStatus.OK);
            return Mono.just(response);
        }
    }

    public Mono<ResponseEntity<Object>> deleteBookById(Integer bookId) {
        bookDetailsRepo.deleteById(bookId);
        ResponseEntity<Object> response = ResponseHandler.responseBuilder("Book deleted successfully", HttpStatus.OK);
        return Mono.just(response);
    }
}
