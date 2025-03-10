package com.futurespace.springdata.controller;

import com.futurespace.springdata.entity.Genre;
import com.futurespace.springdata.repository.GenreRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // Create a new Genre
    @PostMapping
    public Genre saveGenre(@Valid @RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    // Retrieve a specific Genre by ID
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isPresent()) {
            return ResponseEntity.ok(optionalGenre.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Retrieve all Genres
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Update an existing Genre
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @Valid @RequestBody Genre genreRequest) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isPresent()) {
            Genre existingGenre = optionalGenre.get();
            existingGenre.setName(genreRequest.getName());
            Genre updatedGenre = genreRepository.save(existingGenre);
            return ResponseEntity.ok(updatedGenre);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a Genre by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
