package com.lms.bff.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@Builder
@Table("users")
public class UserEntity {

  @Id
  @Column("user_id")
  private Integer userId;

  @Column("mobile_number")
  private String mobileNumber;

  private String name;
  // to differentiate the users access level from that of admins;
  @Column("access_level")
  private String accessLevel;

  @Column("rented_books_list")
  private List<Integer> rentedBooksList;
}
