package com.tma.bookmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tma.bookmanagement.entities.Category;
import com.tma.bookmanagement.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category_list")
    public String listCategory(Model model) {
        model.addAttribute("listCategory", categoryService.findAll());
        return "list_category";
    }

    @RequestMapping("/category_save")
    public String insertCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category_save";
    }

    @RequestMapping("/saveCategory")
    public String doSaveCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category/category_list";
    }

    @RequestMapping("/category_view/{id}")
    public String viewCategory(@PathVariable Long id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
        }
        return "category_view";
    }

    @RequestMapping("/category_update/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
        }
        return "category_update";
    }

    @RequestMapping("/updateCategory")
    public String doUpdateCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category/category_list";
    }

    @RequestMapping("deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category/category_list";
    }
}
