package com.tma.bookmanagement.services;

import com.tma.bookmanagement.entities.BookBorrow;

import java.util.List;
import java.util.Optional;

public interface BookBorrowService {
    List<BookBorrow> findAll();
    Optional<BookBorrow> findById(Long id);
    void save(BookBorrow bookBorrow);
    void delete(Long id);
}
