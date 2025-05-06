package com.lms.bff.controller;

import com.lms.bff.service.RentalQueryService;
import com.lms.bff.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")

public class RentalQueryController {

  @Autowired
  RentalQueryService rentalQueryService;

  @GetMapping("/user/{userId}")
  public Mono<ResponseEntity<Object>> getAllBooksRentedByUser(
      @PathVariable String userId
  ){
    return rentalQueryService.getAllBooksRentedByUser(userId);
  }

  @GetMapping("/all-users")
  public Mono<ResponseEntity<Object>> getAllUsers(){
    return rentalQueryService.getAllUsers();
  }
}
