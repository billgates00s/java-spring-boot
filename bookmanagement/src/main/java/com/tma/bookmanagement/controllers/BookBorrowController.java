package com.tma.bookmanagement.controllers;

import com.tma.bookmanagement.entities.Book;
import com.tma.bookmanagement.entities.BookBorrow;
import com.tma.bookmanagement.entities.Employee;
import com.tma.bookmanagement.entities.Student;
import com.tma.bookmanagement.services.BookBorrowService;
import com.tma.bookmanagement.services.BookService;
import com.tma.bookmanagement.services.EmployeeService;
import com.tma.bookmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("bookBorrow")
public class BookBorrowController {
    @Autowired
    private BookBorrowService bookBorrowService;

    @RequestMapping("/bookBorrow_list")
    public String listBookBorrow(Model model) {
        model.addAttribute("listBookBorrow", bookBorrowService.findAll());
        return "list_bookBorrow";
    }

    @RequestMapping("/bookBorrow_save")
    public String insertBookBorrow(Model model) {
        model.addAttribute("bookBorrow", new BookBorrow());
        return "bookBorrow_save";
    }

    @RequestMapping("/bookBorrow_view/{id}")
    public String viewBookBorrow(@PathVariable Long id, Model model) {
        Optional<BookBorrow> bookBorrow = bookBorrowService.findById(id);
        if (bookBorrow.isPresent()) {
            model.addAttribute("bookBorrow", bookBorrow.get());
        }
        return "bookBorrow_view";
    }

    @RequestMapping("/bookBorrow_update/{id}")
    public String updateBookBorrow(@PathVariable Long id, Model model) {
        Optional<BookBorrow> bookBorrow = bookBorrowService.findById(id);
        if (bookBorrow.isPresent()) {
            model.addAttribute("bookBorrow", bookBorrow.get());
        }
        return "bookBorrow_update";
    }
    @Autowired
    private BookService bookService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/saveBookBorrow")
    public String doSaveBookBorrow(@ModelAttribute BookBorrow bookBorrow) {
        Optional<Book> book = bookService.findById(bookBorrow.getBook().getBookId());
        if(book.isEmpty()){
            System.out.println("Book id not exit");
        }
        Optional<Employee> employee = employeeService.findById(bookBorrow.getEmployee().getEmployeeId());
        if(employee.isEmpty()){
            System.out.println("Employee id not exit");
        }
        Optional<Student> student = studentService.findById(bookBorrow.getStudent().getStudentId());
        if(student.isEmpty()){
            System.out.println("Student id not exit");
        }
        bookBorrowService.save(bookBorrow);
        return "redirect:/bookBorrow/bookBorrow_list";
    }
    @RequestMapping("/updateBookBorrow")
    public String doUpdateBookBorrow(@ModelAttribute BookBorrow bookBorrow){
        bookBorrowService.save(bookBorrow);
        return "redirect:/bookBorrow/bookBorrow_list";
    }

    @RequestMapping("deleteBookBorrow/{id}")
    public String doDeleteBookBorrow(@PathVariable("id") Long id) {
        bookBorrowService.delete(id);
        return "redirect:/bookBorrow/bookBorrow_list";
    }
}
