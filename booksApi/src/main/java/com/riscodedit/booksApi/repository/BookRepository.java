package com.riscodedit.booksApi.repository;

import com.riscodedit.booksApi.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book,String>, PagingAndSortingRepository<Book,String> {
}
