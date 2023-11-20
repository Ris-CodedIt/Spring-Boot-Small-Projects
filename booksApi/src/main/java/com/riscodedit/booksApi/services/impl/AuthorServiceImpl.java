package com.riscodedit.booksApi.services.impl;

import com.riscodedit.booksApi.domain.Author;
import com.riscodedit.booksApi.repository.AuthorRepository;
import com.riscodedit.booksApi.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return StreamSupport.stream(authorRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public Optional<Author> findOneById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public boolean isExists(Long authorId) {
        return authorRepository.existsById(authorId);
    }

    @Override
    public Author partialUpdate(Long authorId, Author author) {
        author.setId(authorId);
        return authorRepository.findById(authorId).map(existingAuthor->{
            Optional.ofNullable(author.getName()).ifPresent(existingAuthor::setName);
            Optional.ofNullable(author.getAge()).ifPresent(existingAuthor::setAge);
            return authorRepository.save(existingAuthor);
        }).orElseThrow(()-> new RuntimeException("Author does not exist"));

    }

    @Override
    public void delete(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
