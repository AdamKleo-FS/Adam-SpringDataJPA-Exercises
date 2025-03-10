package com.futurespace.springdata.repository;

import com.futurespace.springdata.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE b.publicationDate > :date")
    List<Book> findBooksPublishedAfter(@Param("date") LocalDate date);

}

