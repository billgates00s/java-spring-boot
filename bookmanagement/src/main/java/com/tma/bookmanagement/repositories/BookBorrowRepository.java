package com.tma.bookmanagement.repositories;

import com.tma.bookmanagement.entities.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
}
