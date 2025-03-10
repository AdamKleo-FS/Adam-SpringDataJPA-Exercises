package com.futurespace.springdata.repository;

import com.futurespace.springdata.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}

