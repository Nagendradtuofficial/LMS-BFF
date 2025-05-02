package com.lms.bff.controller;

import com.lms.bff.entity.RentalRequestModel;
import com.lms.bff.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class RentalController {

  @Autowired
  RentalService rentalService;

  @PostMapping("/rentals")
  public Mono<ResponseEntity<Object>> rentABook(
      @RequestBody RentalRequestModel rentalRequestModel
  ){
    return rentalService.rentABook(rentalRequestModel);
  }

  @PostMapping("/returns")
  public Mono<ResponseEntity<Object>> returnABook(
      @RequestBody RentalRequestModel rentalRequestModel
  ){
    return rentalService.returnABook(rentalRequestModel);
  }


}
