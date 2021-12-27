package com.fs.restapi.repository

import com.fs.restapi.dto.CategoryDTO
import com.fs.restapi.entity.Book
import com.fs.restapi.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll()
    Category findById(Integer id)
    Category save(Category category)
    void delete(Category category)

    String rawQuery1 = "select * from categories c";
    @Query(nativeQuery = true, value = rawQuery1)
    List<Category> findAllCategories();


    String rawQuery2 = "SELECT * FROM categories c WHERE id = ?1";
    @Query(nativeQuery = true, value = rawQuery2)
    List<Category> findCategory(Integer id);
}