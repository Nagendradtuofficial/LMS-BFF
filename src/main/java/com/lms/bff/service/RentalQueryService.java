package com.lms.bff.service;

import com.lms.bff.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RentalQueryService {
  public Mono<ResponseEntity<Object>> getAllBooksRentedByUser(String userId) {
    ResponseEntity<Object> resp = ResponseHandler.responseBuilder("Rented a Book", HttpStatus.OK, userId);
    return Mono.just(resp);
  }

  public Mono<ResponseEntity<Object>> getAllUsers() {
    ResponseEntity<Object> resp = ResponseHandler.responseBuilder("Rented a Book", HttpStatus.OK, "All Users List");
    return Mono.just(resp);
  }
}
