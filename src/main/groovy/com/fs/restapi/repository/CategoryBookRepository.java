package com.fs.restapi.repository;

import com.fs.restapi.entity.Book;
import com.fs.restapi.entity.Category;
import com.fs.restapi.entity.CategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

interface CategoryBookRepository extends JpaRepository<Book, Integer> {
    String rawQuery = "select * from books b where b.category_id = ?1";

    @Query(nativeQuery = true, value = rawQuery)
    List<Book> findAllByBookId(Integer bookId);
}
