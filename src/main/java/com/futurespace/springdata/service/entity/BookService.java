package com.futurespace.springdata.service.entity;

import com.futurespace.springdata.entity.Book;
import com.futurespace.springdata.repository.BookRepository;
import com.futurespace.springdata.service.BaseService;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class BookService extends BaseService<Book, String> {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksPublishedAfter(LocalDate date) {
        return bookRepository.findBooksPublishedAfter(date);
    }

    // Additional book-specific methods can go here
}
