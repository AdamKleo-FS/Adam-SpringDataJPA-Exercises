package com.futurespace.springdata.controller.entity;

import com.futurespace.springdata.controller.BaseController;
import com.futurespace.springdata.entity.Author;
import com.futurespace.springdata.service.entity.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController extends BaseController<Author, Long> {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        super(authorService);
        this.authorService = authorService;
    }

    // Add any additional author-specific endpoints here if needed
}
