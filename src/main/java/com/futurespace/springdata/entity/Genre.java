package com.futurespace.springdata.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Genre")
@Table(
        name = "Genre",
        uniqueConstraints = {
                @UniqueConstraint(name = "genre_name_unique", columnNames = "genre_name")
        }
)
public class Genre {

    @Id
    @SequenceGenerator(
            name = "genre_sequence",
            sequenceName = "genre_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "genre_name",
            nullable = false
    )
    @NotBlank(message = "Genre name cannot be empty")
    @Size(max = 50, message = "Genre name cannot exceed 50 characters")
    private String name;


    public Genre(String name) {
        this.name = name;
    }

    public Genre() {

    }

    public String getName() {
        return name;
    }

    public void setName(String genreName) {
        this.name = genreName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
