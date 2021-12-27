package com.fs.restapi.repository


import com.fs.restapi.entity.Book
import com.fs.restapi.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll()
    Book findById(Integer id)
    Book save(Book book)
    void delete(Book book)

    String rawQuery = "select * from books b";

    @Query(nativeQuery = true, value = rawQuery)
    List<Category> findAllBooks();
}