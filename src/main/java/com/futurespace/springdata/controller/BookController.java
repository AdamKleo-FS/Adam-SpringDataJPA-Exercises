package com.futurespace.springdata.controller;


import com.futurespace.springdata.entity.Book;
import com.futurespace.springdata.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create a new Book
    @PostMapping
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Retrieve a specific Book by ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        return bookOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve all Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Update a Book (except the ISBN, which is immutable)
    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @Valid @RequestBody Book bookRequest) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            Book existingBook = bookOptional.get();
            // Update mutable fields
            existingBook.setTitle(bookRequest.getTitle());
            existingBook.setPublicationDate(bookRequest.getPublicationDate());
            existingBook.setGenre(bookRequest.getGenre());
            // Optionally  update associations (authors/publishers) as needed:
            // existingBook.setAuthors(bookRequest.getAuthors());
            // existingBook.setPublishers(bookRequest.getPublishers());
            Book updatedBook = bookRepository.save(existingBook);
            return ResponseEntity.ok(updatedBook);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a Book by ISBN
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        if (bookRepository.existsById(isbn)) {
            bookRepository.deleteById(isbn);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
