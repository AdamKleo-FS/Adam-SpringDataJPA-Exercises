package com.futurespace.springdata.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Book")
public class Book {

    @Id
    @Column(
            name = "ISBN",
            updatable = false
    )
    @Pattern(
            regexp = "^(?:\\d{9}[\\dXx]|\\d{13})$",
            message = "Invalid ISBN format. Must be 10 or 13 digits, with optional 'X' for ISBN-10."
    )
    private String ISBN;

    @Column(
            name = "book_title",
            nullable = false
    )
    @NotBlank(message = "Book title cannot be empty")
    @Size(max = 100, message = "Book title cannot exceed 100 characters")
    private String title;

    @Column(name = "book_publication_date", nullable = false)
    @NotNull(message = "Publication date cannot be null")
    @Past(message = "Publication date must be in the past")
    private LocalDate publicationDate;


    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_book_genre"))
    @NotNull(message = "Genre cannot be null")
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "WrittenBy",
            joinColumns = @JoinColumn(name = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "PublishedBy",
            joinColumns = @JoinColumn(name = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private Set<Publisher> publishers = new HashSet<>();

    public Book(Genre genre, String ISBN, LocalDate publicationDate, String title) {
        this.genre = genre;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
        this.title = title;
    }

    public Book() {

    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", genre=" + (genre != null ? genre.getName() : "null") + // Avoid LazyException
                '}';
    }
}
