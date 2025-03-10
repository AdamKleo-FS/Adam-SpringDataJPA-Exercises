package com.futurespace.springdata.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Publisher")
public class Publisher {


    @Id
    @SequenceGenerator(
            name = "publisher_sequence",
            sequenceName = "publisher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "publisher_sequence"
    )
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name", nullable = false)
    @NotBlank(message = "Publisher name cannot be null or blank.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Publisher name can only contain letters.")
    @Size(min = 3, max = 15, message = "Publisher name must be between 3 and 15 characters")
    private String name;

    @Column(name = "legal_name", nullable = false)
    @NotBlank(message = "Publisher legal name name cannot be null or blank.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Publisher legal name can only contain letters.")
    @Size(min = 3, max = 15, message = "Publisher legal name must be between 3 and 15 characters")
    private String legalName;

    @ManyToMany(mappedBy = "publishers")
    private Set<Book> books = new HashSet<>();


    public Publisher(String name, String legalName) {
        this.name = name;
        this.legalName = legalName;
    }

    public Publisher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "books=" + books +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", legalName='" + legalName + '\'' +
                '}';
    }
}
