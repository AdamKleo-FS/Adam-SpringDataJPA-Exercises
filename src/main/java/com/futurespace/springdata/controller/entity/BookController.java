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


    // Add any additional book-specific endpoints here if needed

}
