package com.femialex.mapstructexample.controllers;

import com.femialex.mapstructexample.mapstruct.mapper.MapStructMapper;
import com.femialex.mapstructexample.mapstruct.model.BookDto;
import com.femialex.mapstructexample.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final MapStructMapper mapStructMapper;

    private final BookRepository bookRepository;

    public BookController(MapStructMapper mapStructMapper, BookRepository bookRepository) {
        this.mapStructMapper = mapStructMapper;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable(value = "id") Long id){

        return new ResponseEntity<>(
                mapStructMapper.bookToBookDto(
                        bookRepository.findById(id).get()
                ), HttpStatus.OK
        );

    }
}
