package com.lms.bff.service;

import com.lms.bff.constants.Constants;
import com.lms.bff.entity.UserEntity;
import com.lms.bff.exceptions.BasicErrorMessageException;
import com.lms.bff.repository.AccountDetailsRepo;
import com.lms.bff.service.impl.BookDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class AccountDetailsService {
  private static final Logger logger = LoggerFactory.getLogger(BookDetailsServiceImpl.class);

  @Autowired
  AccountDetailsRepo accountDetailsRepo;

  public Mono<String> createAccount(UserEntity user) {
    String accountType = user.getAccessLevel();
    if(!Objects.equals(accountType, Constants.USER) && !Objects.equals(accountType, Constants.ADMIN)) {
      return Mono.error(new BasicErrorMessageException("Invalid Account Type", HttpStatus.BAD_REQUEST));
    }

  return accountDetailsRepo.save(user)
          .thenReturn("New " + accountType +" Added")
          .onErrorResume(error -> {
            logger.error("Error adding {} : ", accountType, error);
            return Mono.error(new BasicErrorMessageException( "Database Error: " + error.getMessage()));
          });
  };

  public Flux<UserEntity> retrieveAccountsByType(String accountType){
    if (accountType == null || accountType.isBlank()) {
      return accountDetailsRepo.findAll()
               .onErrorResume(error -> {
                 logger.error("Error fetching all accounts: ", error);
                 return Flux.empty();
               });
    }
    return accountDetailsRepo.findByAccessLevel(accountType)
             .onErrorResume(error -> {
               logger.error("Error fetching all accounts: ", error);
               return Flux.empty();
             });
  }

  public Mono<UserEntity> getAccountDetailsById(Integer accountId){
    return accountDetailsRepo.findById(accountId);
  }
}
