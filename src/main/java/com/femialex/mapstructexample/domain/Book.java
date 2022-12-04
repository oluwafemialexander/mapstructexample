package com.femialex.mapstructexample.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @Column(name = "id",unique = true, nullable = false)
    private Long id;

    @Column(name = "title",nullable = false, length = 250)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date",nullable = true)
    private Date releaseDate;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<User> users = new LinkedHashSet<>();

}