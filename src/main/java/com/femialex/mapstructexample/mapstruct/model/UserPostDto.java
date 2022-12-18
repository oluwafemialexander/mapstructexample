package com.femialex.mapstructexample.mapstruct.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostDto {

    @JsonProperty("id")
    private Long id;


    @Email
    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("passsword")
    private  String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;
}
