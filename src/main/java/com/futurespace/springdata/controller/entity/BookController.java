package com.futurespace.springdata.controller.entity;

import com.futurespace.springdata.controller.BaseController;
import com.futurespace.springdata.entity.Book;
import com.futurespace.springdata.service.entity.BookService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController<Book, String> {

    private final BookService bookService;

    public BookController(BookService bookService) {
        super(bookService);
        this.bookService = bookService;
    }

    // Custom endpoint for books published after a certain date
    @GetMapping("/published-after")
    public List<Book> getBooksPublishedAfter(@RequestParam("date") String date) {
        LocalDate publicationDate = LocalDate.parse(date);
        return bookService.getBooksPublishedAfter(publicationDate);
    }

    // Q1: Get books published between two dates
    @GetMapping("/published-between")
    public List<Book> getBooksPublishedBetween(@RequestParam("start") String startDate,
                                               @RequestParam("end") String endDate) {
        return bookService.getBooksPublishedBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    // Q2: Get book with ISBN
    @GetMapping("/fixed-isbn")
    public Book getBookByIsbn(@RequestParam("isbn") String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    // Q3: Get books published by
    @GetMapping("/published-by")
    public List<Book> getBooksByPublisher(@RequestParam("publisher") String publisherName) {
        return bookService.getBooksByPublisher(publisherName);
    }

    // Q4: Get books published by 'RBA' in a specific date range
    @GetMapping("/published-by-between")
    public List<Book> getBooksByPublisherBetween(@RequestParam("publisher") String publisherName,
                                                    @RequestParam("start") String startDate,
                                                    @RequestParam("end") String endDate) {
        return bookService.getBooksByPublisherBetween(publisherName, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
