package com.example.Library.controllers;

import com.example.Library.API.UserApi;
import com.example.Library.entities.BookEntity;
import com.example.Library.models.Book;
import com.example.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    //@Autowired
    //private UserApi userApi;

    @Autowired
    private BookService bookService;

    //Get mapping users tu MircoService User-Service
    /*@GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(userApi.getUsers());
    }*/

    @RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Book> getAll() {

        return bookService.getAll();
    }

    @GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book one(@PathVariable Long id) {
        return bookService.findById(id);
    }

    //Xoa
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Book add(BookEntity book) {
        return bookService.add(book);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Book save(BookEntity book) {
        return bookService.save(book);
    }
}
