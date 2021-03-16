package com.example.Library.controllers;


import com.example.Library.API.UserApi;
import com.example.Library.entities.BookEntity;
import com.example.Library.entities.TicketEntity;
import com.example.Library.models.Book;
import com.example.Library.models.Ticket;
import com.example.Library.services.BookService;
import com.example.Library.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private UserApi userApi;

    @Autowired
    private TicketService ticketService;

    //Get mapping users tu MircoService User-Service
    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(userApi.getUsers());
    }

    @GetMapping(value = "/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

    @GetMapping(value = "/ticket/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket one(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    //Xoa
    /*
    @GetMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
    }


    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    Ticket add(TicketEntity ticket) {
        return ticketService.add(ticket);
    }
    */
}
