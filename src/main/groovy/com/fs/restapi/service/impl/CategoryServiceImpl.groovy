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

    @Override
    Category save(Category category) {
        CategoryRepository.save(category)
    }

    @Override
    Category update(Category category, int id) {
        def record = CategoryRepository.findById(id)
        record.with {
            name = category.name
        }
        CategoryRepository.save(record)
        record
    }

}