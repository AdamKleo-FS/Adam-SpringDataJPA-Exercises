package com.futurespace.springdata.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Author")
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(name = "author_id")
    private Long id;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


    @Column(name = "first_name", nullable = false)
    @NotBlank(message="First name cannot be null or blank.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name can only contain letters.")
    @Size(min = 3, max = 15, message = "First name must be between 3 and 15 characters")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message="Last name cannot be null or blank.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name can only contain letters.")
    @Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
    private String lastName;

    @Column(name = "birth_date")
    @Past(message = "Birthdate date must be in the past")
    private LocalDate birthDate;

    public Author(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Author() {

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
