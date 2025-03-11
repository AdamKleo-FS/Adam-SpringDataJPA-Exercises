package com.futurespace.springdata.repository;

import com.futurespace.springdata.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {


    /*
    @Query("SELECT b FROM Book b WHERE b.publicationDate > :date")
    List<Book> findBooksPublishedAfter(@Param("date") LocalDate date);
    */

    List<Book> findByPublicationDateAfter(LocalDate date);

    // Q1
    @Query("SELECT b FROM Book b WHERE b.publicationDate BETWEEN :startDate AND :endDate")
    List<Book> getBooksPublishedBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    // Q2
    @Query("SELECT b FROM Book b where b.isbn = :isbn")
    Book getBookByIsbn(@Param("isbn") String isbn);

    // Q3
    @Query("SELECT b FROM Book b JOIN b.publishers p WHERE p.name = :publisherName")
    List<Book> getBooksByPublisher(@Param("publisherName") String publisherName);


    //Display the books from a publisher published in some range.
    // Q4
    @Query("SELECT b FROM Book b JOIN b.publishers p WHERE p.name = :publisherName AND b.publicationDate BETWEEN :startDate AND :endDate")
    List<Book> getBooksByPublisherBetween(@Param("publisherName") String publisherName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}

