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
        return bookRepository.findByPublicationDateAfter(date);
    }

    // Q1: Get books published between two dates
    public List<Book> getBooksPublishedBetween(LocalDate startDate, LocalDate endDate) {
        return bookRepository.getBooksPublishedBetween(startDate, endDate);
    }

    // Q2: Get book by isbn
    public Book getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }

    // Q3: Get books by publisher
    public List<Book> getBooksByPublisher(String publisherName) {
        return bookRepository.getBooksByPublisher(publisherName);
    }

    // Q4: Get books published by 'RBA' in a specific date range
    public List<Book> getBooksByPublisherBetween(String publisherName, LocalDate startDate, LocalDate endDate) {
        return bookRepository.getBooksByPublisherBetween(publisherName, startDate, endDate);
    }
}
