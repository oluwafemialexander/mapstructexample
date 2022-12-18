package com.femialex.mapstructexample.mapstruct.mapper;

import com.femialex.mapstructexample.domain.Author;
import com.femialex.mapstructexample.domain.Book;
import com.femialex.mapstructexample.domain.User;
import com.femialex.mapstructexample.mapstruct.model.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    BookSlimDto bookToBookSlimDto(
            Book book
    );

    BookDto bookToBookDto(
            Book book
    );

    AuthorDto authorToAuthorDto(
            Author author
    );

    AuthorAllDto authorToAuthorAllDto(
            Author author
    );

    List<AuthorAllDto> authorsToAuthorAllDtos(
            List<Author> authors
    );

    UserGetDto userToUserGetDto(
            User user
    );

    User userPostDtoToUser(
            UserPostDto userPostDto
    );
}
