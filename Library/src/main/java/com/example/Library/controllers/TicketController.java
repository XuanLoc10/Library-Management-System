package com.example.Library.controllers;

import com.example.Library.API.UserApi;
import com.example.Library.entities.TicketEntity;
import com.example.Library.models.Ticket;
import com.example.Library.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private UserApi userApi;

    @Autowired
    private TicketService ticketService;

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

    @GetMapping("/deleteTicket/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
    }

    @PostMapping(value = "/addTicket", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Ticket addTicket(TicketEntity ticket) {
        return ticketService.addTicket(ticket);
    }

    @PostMapping(value = "/saveTicket", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Ticket saveTicket(TicketEntity ticket) {
        return ticketService.saveTicket(ticket);
    }
}
