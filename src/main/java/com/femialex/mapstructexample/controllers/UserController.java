package com.femialex.mapstructexample.controllers;

import com.femialex.mapstructexample.mapstruct.mapper.MapStructMapper;
import com.femialex.mapstructexample.mapstruct.model.UserGetDto;
import com.femialex.mapstructexample.mapstruct.model.UserPostDto;
import com.femialex.mapstructexample.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final MapStructMapper mapStructMapper;

    private final UserRepository userRepository;

    public UserController(MapStructMapper mapStructMapper, UserRepository userRepository) {
        this.mapStructMapper = mapStructMapper;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserPostDto userPostDto){
        userRepository.save(
                mapStructMapper.userPostDtoToUser(userPostDto)
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getById(@PathVariable(value = "id") Long id){
            return new ResponseEntity<>(mapStructMapper.userToUserGetDto(
                    userRepository.findById(id).get()
            ),HttpStatus.OK
            );
    }
}
