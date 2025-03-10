package com.futurespace.springdata.controller;


import com.futurespace.springdata.entity.Publisher;
import com.futurespace.springdata.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    // Create
    @PostMapping
    public Publisher savePublisher(@Valid @RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // Retrieve a specific publisher by ID
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        return publisher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve all publishers
    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }


    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @Valid @RequestBody Publisher publisherRequest) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            Publisher existingPublisher = publisherOptional.get();
            // Update fields from publisherRequest. For example:
            existingPublisher.setName(publisherRequest.getName());
            existingPublisher.setLegalName(publisherRequest.getLegalName());
            // Update any additional fields as needed.
            Publisher updatedPublisher = publisherRepository.save(existingPublisher);
            return ResponseEntity.ok(updatedPublisher);
        }
        return ResponseEntity.notFound().build();
    }


    // Delete a publisher by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        if(publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }




}


