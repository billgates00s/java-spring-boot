package com.tma.bookmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book", //
        uniqueConstraints = {//
                @UniqueConstraint(name = "book_uk", columnNames = "name_book")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id",nullable = false)
    private Long bookId;

    private String name_book;

    private boolean status_borrow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
