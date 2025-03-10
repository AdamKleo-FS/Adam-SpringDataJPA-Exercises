package com.futurespace.springdata.controller;

import com.futurespace.springdata.entity.Author;
import com.futurespace.springdata.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Create
    @PostMapping
    public Author saveAuthor(@Valid @RequestBody Author author) {
        return authorRepository.save(author);
    }

    // Retrieve a specific author by ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve all authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @Valid @RequestBody Author updatedAuthor) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            existingAuthor.setFirstName(updatedAuthor.getFirstName());
            existingAuthor.setLastName(updatedAuthor.getLastName());
            existingAuthor.setBirthDate(updatedAuthor.getBirthDate());
            Author savedAuthor = authorRepository.save(existingAuthor);
            return ResponseEntity.ok(savedAuthor);
        }
        return ResponseEntity.notFound().build();
    }


    // Delete an author by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if(authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

