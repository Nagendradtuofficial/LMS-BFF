package com.lms.bff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BasicErrorMessageException extends ResponseStatusException {

  private static final long serialVersionUID = 1L;

  public BasicErrorMessageException(String message, HttpStatus httpStatus){
    super(httpStatus , message);
  }

  public BasicErrorMessageException(String message){
    super(HttpStatus.INTERNAL_SERVER_ERROR , message);
  }
}
