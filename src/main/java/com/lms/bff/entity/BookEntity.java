package com.lms.bff.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("books")
public class BookEntity {

    @Id
    @Column("book_id")
    private Integer bookId;
    private String description;
    private String title;
    private Integer quantity;

}
