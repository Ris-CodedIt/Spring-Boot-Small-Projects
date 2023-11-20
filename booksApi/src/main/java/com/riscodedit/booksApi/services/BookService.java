package com.riscodedit.booksApi.services;

import com.riscodedit.booksApi.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book createBook(String isbn, Book book);

    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Optional<Book> findOneByIsbn(String isbn);

    boolean isExists(String isbn);

    void delete(String isbn);
}
