package com.femialex.mapstructexample.repositories;

import com.femialex.mapstructexample.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
