package com.fs.restapi.controller

import com.fs.restapi.dto.CategoryDTO
import com.fs.restapi.entity.Category
import com.fs.restapi.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping('/categories')
class CategoryController {
    @Autowired
    private final CategoryService categoryService
    @GetMapping('')
    List<Category> findAll(
        @RequestParam(value="includeBooks",required = false) boolean include
    ) {
        categoryService.findAll(include)
    }

    @GetMapping('{id}')
    CategoryDTO findById(
        @PathVariable('id') int id,
        @RequestParam(value="includeBooks",required = false) boolean include
    ) {
        categoryService.findById(id,include)
    }

    @PostMapping()
    Category save(@RequestBody Category category) {
        categoryService.save(category)
    }

    @PutMapping('{id}')
    Category update(@RequestBody Category category, @PathVariable('id') int id) {
        categoryService.update(category, id)
    }

    @DeleteMapping('{id}')
    Category delete(@PathVariable('id') int id) {
        categoryService.delete(id)
    }
}