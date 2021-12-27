package com.fs.restapi.service

import com.fs.restapi.dto.CategoryDTO
import com.fs.restapi.entity.Category

interface CategoryService { 
    List<Category> findAll(boolean includeBooks)
    CategoryDTO findById(int id, boolean includeBooks)
    Category save(Category category)
    Category update(Category category, int id)
    Category delete(int id)
}