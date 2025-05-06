package com.lms.bff.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RentalRequestModel {
  @JsonProperty("book_id")
  private String bookId;

  @JsonProperty("user_id")
  private String userId;
}
