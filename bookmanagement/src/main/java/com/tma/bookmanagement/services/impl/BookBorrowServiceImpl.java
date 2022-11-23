package com.tma.bookmanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.bookmanagement.entities.BookBorrow;
import com.tma.bookmanagement.repositories.BookBorrowRepository;
import com.tma.bookmanagement.services.BookBorrowService;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookBorrowRepository bookBorrowRepository;
    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAll();
    }

    @Override
    public Optional<BookBorrow> findById(Long id) {

        return bookBorrowRepository.findById(id);
    }

    @Override
    public void save(BookBorrow bookBorrow) {
        bookBorrowRepository.save(bookBorrow);
    }

    @Override
    public void delete(Long id) {
        bookBorrowRepository.deleteById(id);

    }
}
