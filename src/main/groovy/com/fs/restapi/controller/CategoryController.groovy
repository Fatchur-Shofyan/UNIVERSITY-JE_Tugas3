package com.fs.restapi.controller

import com.fs.restapi.entity.Category
import com.fs.restapi.service.CategoryService
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping('/categories')
class CategoryController {
    @Autowired
    private final CategoryService categoryService
    @GetMapping('')
    List<Category> findAll() {
        categoryService.findAll()
    }

    @GetMapping('{id}')
    Category findById(@PathVariable('id') int id) {
        categoryService.findById(id)
    }

    @PostMapping()
    Category save(@RequestBody Category category) {
        categoryService.save(category)
    }
}