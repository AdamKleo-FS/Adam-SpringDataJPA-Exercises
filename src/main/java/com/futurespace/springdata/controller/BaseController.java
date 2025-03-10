package com.futurespace.springdata.controller;

import com.futurespace.springdata.entity.Author;
import com.futurespace.springdata.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T, ID> {

    protected final BaseService<T, ID> service;


    public BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        return service.save(entity);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<T>> createAll(@Valid @RequestBody List<T> entities) {
        return service.saveAll(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        return service.delete(id);
    }
}

