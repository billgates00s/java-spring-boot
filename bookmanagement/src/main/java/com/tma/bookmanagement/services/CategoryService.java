package com.tma.bookmanagement.services;

import com.tma.bookmanagement.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void insertCategory(Category category);

    List<Category> findAll();

    void updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    void save(Category category);

    Optional<Category> findById(Long id);

}
