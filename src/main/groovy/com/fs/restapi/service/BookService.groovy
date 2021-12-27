package com.fs.restapi.service

import com.fs.restapi.dto.BookDTO
import com.fs.restapi.entity.Book

interface BookService {
    List<Book> findAll(String include)
    BookDTO findById(int id, String include)
    Book save(Book book)
    Book update(Book book, int id)
    Book delete(int id)
}