package com.futurespace.springdata.repository;


import com.futurespace.springdata.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
