package com.fs.restapi.service.impl


import com.fs.restapi.entity.Book
import com.fs.restapi.repository.BookRepository
import com.fs.restapi.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository BookRepository
    @Override List<Book> findAll() {
        BookRepository.findAll()
    }

    @Override
    Book findById(int id, boolean include) {
        Book book;
        if(include) {

        } else {
            BookRepository.findById(id)
        }
    }

    @Override
    Book save(Book book) {
        BookRepository.save(book)
    }

    @Override
    Book update(Book book, int id) {
        def record = BookRepository.findById(id)
        record.with {
            name = book.name
        }
        BookRepository.save(record)
        record
    }

    @Override
    Book delete(int id) {
        def record = BookRepository.findById(id)
        BookRepository.delete(record)
        record
    }
}