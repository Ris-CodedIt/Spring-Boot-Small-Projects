package com.riscodedit.booksApi.services;

import com.riscodedit.booksApi.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    boolean isExists(Long authorId) ;

    Author createAuthor(Author author);

    List<Author> findAll();

    Page<Author> findAll(Pageable pageable);

    Optional<Author> findOneById(Long authorId);

    Author partialUpdate(Long authorId, Author author);

    void delete(Long authorId);
}
