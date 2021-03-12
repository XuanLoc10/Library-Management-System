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

    @Autowired
    private UserApi userApi;

    @Autowired
    private BookService bookService;

    //Get mapping users tu MircoService User-Service
    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(userApi.getUsers());
    }

    @RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Book> getAll() {

        return bookService.getAll();
    }
/*
    @GetMapping("/book/{id}")
    public Book one(@PathVariable Long isbn) {
        return bookService.findById(isbn);
        //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    */

    //Xoa
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        bookService.deleteById(id);
    }

/*
    @PostMapping("/new")
    public Book newUser(@RequestBody Book newBook) {
        return bookService.save(newBook);
    }
*/
}
