package com.fs.restapi.service
import com.fs.restapi.entity.Category

interface CategoryService { 
    List<Category> findAll()
    Category findById(int id)
    Category save(Category category)
    Category update(Category category, int id)
}