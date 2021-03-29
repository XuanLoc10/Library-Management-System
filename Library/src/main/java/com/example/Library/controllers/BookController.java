package com.example.Library.controllers;

import com.example.Library.entities.BookEntity;
import com.example.Library.models.Book;
import com.example.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Book> getAll() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/bookActive", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Book> getActive() {
        return bookService.getActive();
    }

    @GetMapping(value = "/search/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> searchAuthor(@PathVariable String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/deleteBook/{id}")
    public void deleteUser(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Book addBook(BookEntity book) {
        return bookService.addBook(book);
    }

    @PostMapping(value = "/saveBook", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Book saveBook(BookEntity book) {
        return bookService.saveBook(book);
    }
}
