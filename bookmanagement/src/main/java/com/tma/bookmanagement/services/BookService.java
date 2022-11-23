package com.tma.bookmanagement.services;

import com.tma.bookmanagement.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    boolean findByName(String name);

    void deletedBook(Long id);

    Optional<Book> findById(Long id);

    void save(Book book);

}
