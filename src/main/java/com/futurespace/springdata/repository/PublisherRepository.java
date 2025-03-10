package com.futurespace.springdata.repository;

import com.futurespace.springdata.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
