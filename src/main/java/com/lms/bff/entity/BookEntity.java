package com.lms.bff.entity;

public class BookEntity {

    private Integer bookId;
    private String description;
    private String title;
    private Integer quantity;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity(Integer bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookEntity() {
    }

    public BookEntity(Integer bookId, String description, String title, Integer quantity) {
        this.bookId = bookId;
        this.description = description;
        this.title = title;
        this.quantity = quantity;
    }
}
