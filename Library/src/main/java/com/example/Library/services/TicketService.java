package com.example.Library.services;


import com.example.Library.converter.TicketConverter;
import com.example.Library.entities.TicketEntity;
import com.example.Library.models.Ticket;
import com.example.Library.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    //Loi khi su dung Book
    //public Iterable<BookEntity> listAll() {
    //    return bookRepository.findAll();
    //}
    public List<Ticket> getAll() {
        return StreamSupport
                .stream(ticketRepository.findAll().spliterator(), false)
                //.map(UserConverter::entity2Model)
                //Tim cach viet khac
                //Su dung lamda
                .map((TicketEntity entity) -> TicketConverter.entity2Model(entity))
                //Su dung cach de hieu hon
                .collect(Collectors.toList());
    }
}
