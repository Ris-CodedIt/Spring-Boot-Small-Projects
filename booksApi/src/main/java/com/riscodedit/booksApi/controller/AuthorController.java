package com.riscodedit.booksApi.controller;


import com.riscodedit.booksApi.Mappers.Mapper;
import com.riscodedit.booksApi.domain.Author;
import com.riscodedit.booksApi.domain.dto.AuthorDto;
import com.riscodedit.booksApi.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private AuthorService authorService;
    private Mapper<Author, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<Author, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path= "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        Author author = authorMapper.mapFrom(authorDto);
        Author savedAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthor), HttpStatus.CREATED);
    }

    @GetMapping(path = "/authors")
    public List<AuthorDto> findAll(){
        List<Author> authors = authorService.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(authorMapper::mapTo).toList();
         return authorDtos;
    }

    @GetMapping(path = "/authors/{author_id}")
    public ResponseEntity<AuthorDto> findOneById(@PathVariable("author_id") Long author_id){
        Optional<Author> foundAuthor = authorService.findOneById(author_id);
        return  foundAuthor.map(author -> {
            AuthorDto authorDto = authorMapper.mapTo(author);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "authors/{author_id}")
    public ResponseEntity<AuthorDto> fullUpdate(@PathVariable("author_id") Long author_id, @RequestBody AuthorDto authorDto){
        if(!authorService.isExists(author_id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorDto.setId(author_id);
        Author author = authorMapper.mapFrom(authorDto);
        Author savedAuthor = authorService.createAuthor(author);
        AuthorDto savedAuthorDto = authorMapper.mapTo(savedAuthor);

        return new ResponseEntity<>(savedAuthorDto, HttpStatus.OK);

    }

    @PatchMapping(path = "authors/{author_id}")
    public ResponseEntity<AuthorDto> partialUpdate(@PathVariable("author_id") Long author_id, @RequestBody AuthorDto authorDto) {
        if(!authorService.isExists(author_id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Author author = authorMapper.mapFrom(authorDto);
        Author savedAuthor = authorService.partialUpdate(author_id,author);
        AuthorDto savedAuthorDto = authorMapper.mapTo(savedAuthor);

        return new ResponseEntity<>(savedAuthorDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "authors/{author_id}")
    public ResponseEntity partialUpdate(@PathVariable("author_id") Long author_id) {
        if(!authorService.isExists(author_id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorService.delete(author_id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }

}
