package com.fs.restapi.controller

import com.fs.restapi.entity.Book
import com.fs.restapi.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping('/books')
class BookController {
    @Autowired
    private final BookService bookService
    @GetMapping('')
    List<Book> findAll() {
        bookService.findAll()
    }

    @GetMapping('{id}')
    Book findById(
        @PathVariable('id') int id,
        @RequestParam(value="include",required = false) boolean include
    ) {
        bookService.findById(id,include)
    }

    @PostMapping()
    Book save(@RequestBody Book book) {
        bookService.save(book)
    }

    @PutMapping('{id}')
    Book update(@RequestBody Book book, @PathVariable('id') int id) {
        bookService.update(book, id)
    }

    @DeleteMapping('{id}')
    Book delete(@PathVariable('id') int id) {
        bookService.delete(id)
    }
}