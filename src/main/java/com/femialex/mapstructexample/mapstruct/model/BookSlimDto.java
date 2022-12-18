package com.femialex.mapstructexample.mapstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSlimDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;
}
