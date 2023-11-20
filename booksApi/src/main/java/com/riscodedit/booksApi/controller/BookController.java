package com.riscodedit.booksApi.controller;


import com.riscodedit.booksApi.Mappers.Mapper;
import com.riscodedit.booksApi.domain.Book;
import com.riscodedit.booksApi.domain.dto.BookDto;
import com.riscodedit.booksApi.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {
 private Mapper<Book, BookDto> bookMapper;
 private BookService bookService;

    public BookController(Mapper<Book, BookDto> bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createAndUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto){
         Book book = bookMapper.mapFrom(bookDto);
         boolean bookExists = bookService.isExists(isbn);
         Book savedBook = bookService.createBook(isbn, book);
         BookDto savedBookDto = bookMapper.mapTo(savedBook);
        if(bookExists){
            return new ResponseEntity<>(savedBookDto, HttpStatus.OK);
        }
         return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/books")
    public Page<BookDto> findAll(Pageable pageable){
        Page<Book> books = bookService.findAll(pageable);
        Page<BookDto> bookDtoList = books.map(book -> bookMapper.mapTo(book));
        return  bookDtoList;
    }


    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> findOnByIsbn(@PathVariable("isbn") String isbn){
        Optional<Book> foundBook= bookService.findOneByIsbn(isbn);
        return foundBook.map(book -> {
            BookDto bookDto = bookMapper.mapTo(book);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity delete(@PathVariable("isbn") String isbn){
        if(!bookService.isExists(isbn)){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
