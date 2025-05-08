package com.lms.bff.controller;

import com.lms.bff.entity.BookEntity;
import com.lms.bff.service.impl.BookDetailsServiceImpl;
import com.lms.bff.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class BookDetailsController {

    @Autowired
    BookDetailsServiceImpl bookDetailsService;

    @GetMapping("/books")
    public Mono<ResponseEntity<Object>> getAllBooks(){
        return bookDetailsService.getAllBooks().collectList().flatMap(ResponseHandler::finalResponse);
    }

    @PostMapping("/books")
    public Mono<ResponseEntity<Object>> addNewBook(@RequestBody BookEntity book){
        return bookDetailsService.addNewBook(book).flatMap(ResponseHandler::finalResponse);
    }

    @DeleteMapping("books/{bookId}")
    public Mono<ResponseEntity<Object>> deleteBookById(@PathVariable Integer bookId){
        return bookDetailsService.deleteBookById(bookId).flatMap(ResponseHandler::finalResponse);
    }
}
