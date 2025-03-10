package com.futurespace.springdata.service.entity;

import com.futurespace.springdata.entity.Genre;
import com.futurespace.springdata.repository.GenreRepository;
import com.futurespace.springdata.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends BaseService<Genre, Long> {

    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
    }

    // Add anything only needed by the genre (if needed)
}
