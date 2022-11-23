package com.tma.bookmanagement.services.impl;

import com.tma.bookmanagement.entities.Category;
import com.tma.bookmanagement.repositories.CategoryRepository;
import com.tma.bookmanagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void insertCategory(Category category) {
        categoryRepository.insertCategory(category.getName_category());
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Long id, Category category) {
        categoryRepository.updateCategory(id,category.getName_category());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deletedCategory(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
