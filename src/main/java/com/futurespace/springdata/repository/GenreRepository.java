package com.futurespace.springdata.repository;

import com.futurespace.springdata.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
