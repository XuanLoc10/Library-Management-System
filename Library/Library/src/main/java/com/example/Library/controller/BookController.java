package com.example.Library.controller;

import com.example.Library.Entity.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path="/book")
public class BookController {
    @Autowired
    private Environment env;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of image service running at different ports. // We load balance among them, and display which instance received the request.
        return "TEST";
        //"Hello from Image Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/books")
    public List<Book> getBooks() {
        List<Book> books = Arrays.asList(

        );
        return books;
    }
}
