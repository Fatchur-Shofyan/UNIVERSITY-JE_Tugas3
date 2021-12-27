package com.fs.restapi.service

import com.fs.restapi.dto.CategoryDTO
import com.fs.restapi.entity.Category

interface CategoryService { 
    List<Category> findAll(String include)
    CategoryDTO findById(int id, String include)
    Category save(Category category)
    Category update(Category category, int id)
    Category delete(int id)
}