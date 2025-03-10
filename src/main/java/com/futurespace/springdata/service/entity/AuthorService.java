package com.futurespace.springdata.service.entity;

import com.futurespace.springdata.entity.Author;
import com.futurespace.springdata.repository.AuthorRepository;
import com.futurespace.springdata.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<Author, Long> {

    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }

    // Add anything only needed by the author (if needed)
}
