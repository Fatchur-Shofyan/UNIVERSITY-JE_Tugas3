package com.fs.restapi.service.impl

import com.fs.restapi.dto.BookDTO
import com.fs.restapi.dto.CategoryDTO
import com.fs.restapi.entity.Book
import com.fs.restapi.entity.Category
import com.fs.restapi.entity.CategoryBook
import com.fs.restapi.repository.CategoryBookRepository
import com.fs.restapi.repository.CategoryRepository
import com.fs.restapi.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository CategoryRepository

    @Autowired
    private CategoryBookRepository categoryBookRepository;

    @Override
    List<Category> findAll(boolean includeBooks) {
        List<Category> categories;
        categories = CategoryRepository.findAll();
        List<Category> categoriesList = new ArrayList<>();

//        CategoryRepository.findAll().forEach(category -> categoriesList.add(category));

        if (categories != null) {
            for (Category category : categories) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setName(category.getName());

                List<CategoryBook> categoryBooks = null;
                if (includeBooks) {
                    categoryBooks = categoryBookRepository.findAllByBookId(category.getId());
                }
                List<BookDTO> bookDTOList = new ArrayList<>();
                if (categoryBooks != null) {
                    for (Book categoryBook : categoryBooks) {
                        BookDTO bookDTO = new BookDTO();
                        bookDTO.setId(categoryBook.getId());
                        bookDTO.setName(categoryBook.getName());
                        bookDTO.setIsbn(categoryBook.getIsbn());

                        bookDTOList.add(bookDTO);
                    }

                    categoryDTO.setBooks(bookDTOList);
                }

                categoriesList.add(categoryDTO);
            }
        }
        return categoriesList;
    }

    @Override
    CategoryDTO findById(int id, boolean includeBooks) {
        Category category;
        List<CategoryBook> categoryBooks = null;

        category = CategoryRepository.findById(id);

        if (includeBooks) {
            categoryBooks = categoryBookRepository.findAllByBookId(id);
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        // set book details
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        // get author details
        List<BookDTO> bookDTOList = new ArrayList<>();
        if (categoryBooks != null) {
            for (Book categoryBook : categoryBooks) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setId(categoryBook.getId());
                bookDTO.setName(categoryBook.getName());
                bookDTO.setIsbn(categoryBook.getIsbn());

                bookDTOList.add(bookDTO);
            }

            categoryDTO.setBooks(bookDTOList);
        }
        return categoryDTO;
    }

    @Override
    Category save(Category category) {
        return CategoryRepository.save(category)
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

    @Override
    Category delete(int id) {
        def record = CategoryRepository.findById(id)
        CategoryRepository.delete(record)
        record
    }
}