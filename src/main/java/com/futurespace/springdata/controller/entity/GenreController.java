package com.futurespace.springdata.controller.entity;

import com.futurespace.springdata.controller.BaseController;
import com.futurespace.springdata.entity.Genre;
import com.futurespace.springdata.service.entity.GenreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController extends BaseController<Genre, Long> {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        super(genreService);
        this.genreService = genreService;
    }

    // Add any additional genre-specific endpoints here if needed
}
