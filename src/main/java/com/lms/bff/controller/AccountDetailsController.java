package com.lms.bff.controller;

import com.lms.bff.constants.Constants;
import com.lms.bff.entity.UserEntity;
import com.lms.bff.exceptions.BasicErrorMessageException;
import com.lms.bff.service.AccountDetailsService;
import com.lms.bff.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class AccountDetailsController {

  @Autowired
  AccountDetailsService accountDetailsService;

  @PostMapping("/accounts")
  public Mono<ResponseEntity<Object>> createAccount
      (
          @RequestBody UserEntity user,
          @RequestHeader(value = "x-account-type", required = true) String accountType
      )
  {
      user.setAccessLevel(accountType);

    return accountDetailsService.createAccount(user).flatMap(ResponseHandler::finalResponse);
  }

  @GetMapping("/accounts")
  public Mono<ResponseEntity<Object>> retrieveAccountsByType(
      @RequestParam(value = "AccountType", required = false) String accountType
  ){
    return accountDetailsService.retrieveAccountsByType(accountType).collectList().flatMap(ResponseHandler::finalResponse);
  }

  @GetMapping("/accounts/{accountId}")
  public Mono<ResponseEntity<Object>> getAccountDetailsById(@PathVariable Integer accountId){
    return accountDetailsService.getAccountDetailsById(accountId).flatMap(ResponseHandler::finalResponse);
  }

}
