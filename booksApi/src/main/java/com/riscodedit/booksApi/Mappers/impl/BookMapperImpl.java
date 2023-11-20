package com.riscodedit.booksApi.Mappers.impl;

import com.riscodedit.booksApi.Mappers.Mapper;
import com.riscodedit.booksApi.domain.Book;
import com.riscodedit.booksApi.domain.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class BookMapperImpl implements Mapper<Book, BookDto> {
    private ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public Book mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }
}
