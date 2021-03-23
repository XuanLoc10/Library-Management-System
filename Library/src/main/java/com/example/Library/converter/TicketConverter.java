package com.example.Library.converter;

import com.example.Library.entities.TicketEntity;
import com.example.Library.models.Ticket;

public class TicketConverter {
    public static TicketEntity model2Entity(Ticket t) {
        TicketEntity entity = new TicketEntity();
        entity.setId(t.getId());
        entity.setBook(BookConverter.model2Entity(t.getBook()));
        entity.setBorrowerId(t.getBorrowerId());
        entity.setBorrowerDate(t.getBorrowerDate());
        entity.setReturnDate(t.getReturnDate());
        return entity;
    }

    public static Ticket entity2Model(TicketEntity entity) {
        Ticket t = new Ticket();
        t.setId(entity.getId());
        t.setBook(BookConverter.entity2Model(entity.getBook()));
        t.setBorrowerId(entity.getBorrowerId());
        t.setBorrowerDate(entity.getBorrowerDate());
        t.setReturnDate(entity.getReturnDate());
        return t;
    }
}
