package com.tma.bookmanagement.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "category", //
        uniqueConstraints = {//
                @UniqueConstraint(name = "category_uk", columnNames = "name_category")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id", nullable = false)
    private Long categoryId;

    private String name_category;

}
