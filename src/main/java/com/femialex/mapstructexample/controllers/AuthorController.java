package com.femialex.mapstructexample.controllers;

import com.femialex.mapstructexample.mapstruct.mapper.MapStructMapper;
import com.femialex.mapstructexample.mapstruct.model.AuthorAllDto;
import com.femialex.mapstructexample.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Controller
public class AuthorController {

    private final MapStructMapper mapStructMapper;

    private final AuthorRepository authorRepository;

    public AuthorController(MapStructMapper mapStructMapper, AuthorRepository authorRepository) {
        this.mapStructMapper = mapStructMapper;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public ResponseEntity<List<AuthorAllDto>> getAll(){
        return  new ResponseEntity<>(
          mapStructMapper.authorsToAuthorAllDtos(authorRepository.findAll()), HttpStatus.OK
        );
    }
}
