package com.tma.bookmanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.bookmanagement.entities.Book;
import com.tma.bookmanagement.repositories.BookRepository;
import com.tma.bookmanagement.services.BookService;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean findByName(String name) {
        if(bookRepository.findByName(name)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void deletedBook(Long id) {
        bookRepository.deletedBook(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }


}
