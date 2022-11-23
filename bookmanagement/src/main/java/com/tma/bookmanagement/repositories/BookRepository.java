package com.tma.bookmanagement.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tma.bookmanagement.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM Book WHERE book_id=:id")
    void deletedBook(@Param("id") Long id);

    @Query(nativeQuery = true, value = "Select * FROM Book WHERE name_book=:name")
    boolean findByName(@Param("name") String name);

}
