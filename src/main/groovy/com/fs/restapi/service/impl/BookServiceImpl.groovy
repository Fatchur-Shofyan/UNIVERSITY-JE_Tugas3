package com.fs.restapi.service.impl

import com.fs.restapi.dto.BookDTO
import com.fs.restapi.dto.CategoryDTO
import com.fs.restapi.entity.Book
import com.fs.restapi.entity.Category
import com.fs.restapi.entity.CategoryBook
import com.fs.restapi.repository.BookRepository
import com.fs.restapi.repository.CategoryRepository
import com.fs.restapi.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository BookRepository
    @Autowired
    private final CategoryRepository CategoryRepository

    @Override List<Book> findAll(String include) {
        List<Book> books;
        books = BookRepository.findAll()
        List<Book> booksList = new ArrayList<>();

        if (books != null) {
            for (Book book : books) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setId(book.getId());
                bookDTO.setName(book.getName());
                bookDTO.setIsbn(book.getIsbn());
                bookDTO.setCategory_id(book.getCategory_id());

                List<Category> categoryBooks = null;
                if (include == "categories") {
                    categoryBooks = CategoryRepository.findCategory(book.getCategory_id());
                }
                List<BookDTO> categoryDTOList = new ArrayList<>();
                if (categoryBooks != null) {
                    for (Category categoryBook : categoryBooks) {
                        CategoryDTO categoryDTO = new CategoryDTO();
                        categoryDTO.setId(categoryBook.getId());
                        categoryDTO.setName(categoryBook.getName());

                        categoryDTOList.add(categoryDTO);
                    }

                    bookDTO.setCategory(categoryDTOList);
                }

                booksList.add(bookDTO);
            }
        }
        return booksList;
    }

    @Override
    BookDTO findById(int id, String include) {
        Book book;
        List<Category> categoryBooks = null;

        book = BookRepository.findById(id);

        if (include == "categories") {
            categoryBooks = CategoryRepository.findCategory(book.getCategory_id());
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setCategory_id(book.getCategory_id());

        List<BookDTO> categoryDTOList = new ArrayList<>();
        if (categoryBooks != null) {
            for (Category categoryBook : categoryBooks) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(categoryBook.getId());
                categoryDTO.setName(categoryBook.getName());

                categoryDTOList.add(categoryDTO);
            }

            bookDTO.setCategory(categoryDTOList);
        }
        return bookDTO;
    }

    @Override
    Book save(Book book) {
        BookRepository.save(book)
    }

    @Override
    Book update(Book book, int id) {
        def record = BookRepository.findById(id)
        record.with {
            name = book.name
        }
        BookRepository.save(record)
        record
    }

    @Override
    Book delete(int id) {
        def record = BookRepository.findById(id)
        BookRepository.delete(record)
        record
    }
}