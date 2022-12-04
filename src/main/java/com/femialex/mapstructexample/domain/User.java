package com.femialex.mapstructexample.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @Column(name = "id",unique = true,nullable = false)
    private Long id;

    @Column(name = "email",nullable = false,length = 250)
    private String email;

    @Column(name = "password",nullable = false,length = 50)
    private String password;

    @Column(name = "name",nullable = true ,length = 50)
    private String name;

    @Column(name = "surname",nullable = true, length = 50)
    private String surname;

    @ManyToMany
    @JoinTable(name = "user_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    private Set<Book> books = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
