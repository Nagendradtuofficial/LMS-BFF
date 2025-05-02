package com.lms.bff.service;

import com.lms.bff.entity.RentalRequestModel;
import com.lms.bff.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RentalService {
  public Mono<ResponseEntity<Object>> rentABook(RentalRequestModel rentalRequestModel) {
    ResponseEntity<Object> resp = ResponseHandler.responseBuilder("Rented a Book", HttpStatus.OK);
    return Mono.just(resp);
  }

  public Mono<ResponseEntity<Object>> returnABook(RentalRequestModel rentalRequestModel) {
    ResponseEntity<Object> resp = ResponseHandler.responseBuilder("Returned a Book", HttpStatus.CREATED);
    return Mono.just(resp);
  }
}
