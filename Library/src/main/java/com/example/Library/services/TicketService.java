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

    public List<Ticket> getAll() {
        return StreamSupport
                .stream(ticketRepository.findAll().spliterator(), false)
                //.map(UserConverter::entity2Model)
                .map((TicketEntity entity) -> TicketConverter.entity2Model(entity))
                .collect(Collectors.toList());
    }

    public Ticket findById(Long id) {
        TicketEntity entity = ticketRepository.findById(id).get();
        Ticket ticket = TicketConverter.entity2Model(entity);
        return ticket;
    }

    public Ticket addTicket(TicketEntity ticket) {
        TicketEntity ticketEntity = ticketRepository.findById(ticket.getId()).get();
        if (ticketEntity == null) {
            ticketEntity = ticketRepository.save(ticket);
            return TicketConverter.entity2Model(ticketEntity);
        }
        return null;
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    public Ticket saveTicket(TicketEntity ticket) {
        TicketEntity ticketEntity = ticketRepository.findById(ticket.getId()).get();
        if (ticketEntity != null) {
            ticketEntity = ticketRepository.save(ticket);
            return TicketConverter.entity2Model(ticketEntity);
        }
        return null;
    }
}
