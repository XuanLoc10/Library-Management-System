package com.example.Library.controllers;

import com.example.Library.models.Book;
import com.example.Library.models.Ticket;
import com.example.Library.services.BookService;
import com.example.Library.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/tickets")
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

}
