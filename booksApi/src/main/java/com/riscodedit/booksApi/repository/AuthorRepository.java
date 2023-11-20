package com.riscodedit.booksApi.repository;


import com.riscodedit.booksApi.domain.Author;
import com.riscodedit.booksApi.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long>, PagingAndSortingRepository<Author,Long> {
}
