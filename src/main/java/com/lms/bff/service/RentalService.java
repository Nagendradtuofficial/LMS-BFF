package com.lms.bff.service;

import com.lms.bff.entity.RentalRequestModel;
import com.lms.bff.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RentalService {
  public Mono<String> rentABook(RentalRequestModel rentalRequestModel) {
    return Mono.just("Book Rented");
  }

  public Mono<String> returnABook(RentalRequestModel rentalRequestModel) {
    return Mono.just("Book Returned");
  }
}
