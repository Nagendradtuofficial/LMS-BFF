package com.lms.bff.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
  public  static ResponseEntity<Object> responseBuilder(
      String message , HttpStatus httpStatus , Object responseObject
  ){
    Map<String, Object> response = new HashMap<>();
    response.put("message", message);
    response.put("httpStatus", httpStatus);
    response.put("data", responseObject);

    return new ResponseEntity<>(response, httpStatus);
  }

  public static ResponseEntity<Object> responseBuilder(
      String message, HttpStatus httpStatus
  ){
    Map<String, Object> response = new HashMap<>();
    response.put("message", message);
    response.put("httpStatus", httpStatus);

    return new ResponseEntity<>(response, httpStatus);
  }

  public static ResponseEntity<Object> responseBuilder(
      Object responseObject
  ){
    Map<String, Object> response = new HashMap<>();
    response.put("data", responseObject);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  public static Mono<ResponseEntity<Object>> finalResponse(
       Object responseObject
  ){
    ResponseEntity<Object> resp = ResponseHandler.responseBuilder(responseObject);
    return Mono.just(resp);
  }
}
