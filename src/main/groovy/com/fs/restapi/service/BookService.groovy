package com.fs.restapi.service


import com.fs.restapi.entity.Book

interface BookService {
    List<Book> findAll()

    Book findById(int id, boolean include)
    Book save(Book book)
    Book update(Book book, int id)
    Book delete(int id)
}