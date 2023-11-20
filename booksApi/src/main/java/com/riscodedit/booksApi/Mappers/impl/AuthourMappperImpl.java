package com.riscodedit.booksApi.Mappers.impl;

import com.riscodedit.booksApi.Mappers.Mapper;
import com.riscodedit.booksApi.domain.Author;
import com.riscodedit.booksApi.domain.dto.AuthorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class AuthourMappperImpl  implements Mapper<Author, AuthorDto> {
   private ModelMapper modelMapper;

    public AuthourMappperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapTo(Author author) {
       return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public Author mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }
}
