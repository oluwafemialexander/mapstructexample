package com.femialex.mapstructexample.repositories;

import com.femialex.mapstructexample.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
