package com.tma.bookmanagement.controllers;

import java.util.Optional;

import com.tma.bookmanagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tma.bookmanagement.entities.Book;
import com.tma.bookmanagement.services.BookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book_list")
    public String listBook(Model model) {
        model.addAttribute("listBook", bookService.findAll());
        return "list_book";
    }

    @RequestMapping("/book_save")
    public String insertBook(Model model) {
        model.addAttribute("book", new Book());
        return "book_save";
    }

    @RequestMapping("/book_view/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        }
        return "book_view";
    }

    @RequestMapping("/book_update/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        }
        return "book_update";
    }

    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/saveBook")
    public String doSaveBook(@ModelAttribute Book book, Model model) {
        if((categoryService.findById(book.getCategory().getCategoryId())).isPresent()){
            bookService.save(book);
        }else{
            model.addAttribute("Error", "CategoryID not exit");
            System.out.println("CategoryID not exit");
            return "redirect:/book/book_save";
        }
        return "redirect:/book/book_list";
    }
    @RequestMapping("/updateBook")
    public String doUpdateBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/book/book_list";
    }

    @RequestMapping("deleteBook/{id}")
    public String doDeleteBook(@PathVariable("id") Long id) {
        bookService.deletedBook(id);
        return "redirect:/book/book_list";
    }
//    @RequestMapping("/search")
//    public ModelAndView search(@RequestParam String keyword){
//
//        ModelAndView mav = new ModelAndView()
//    }
}
