package com.fs.restapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BookDTO> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
