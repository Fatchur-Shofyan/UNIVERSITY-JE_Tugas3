package com.fs.restapi.service.impl
import com.fs.restapi.entity.Category
import com.fs.restapi.repository.CategoryRepository
import com.fs.restapi.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository CategoryRepository
    @Override List<Category> findAll() {
        CategoryRepository.findAll()
    }
    @Override
    Category findById(int id) {
        CategoryRepository.findById(id)
    }
}