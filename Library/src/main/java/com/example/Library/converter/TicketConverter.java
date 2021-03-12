package com.example.Library.converter;

import com.example.Library.entities.BookEntity;
import com.example.Library.entities.TicketEntity;
import com.example.Library.models.Book;
import com.example.Library.models.Ticket;

public class TicketConverter {
    public static TicketEntity model2Entity(Ticket t) {
        TicketEntity entity = new TicketEntity();
        //Su dung phuong thuc set, get AbstractBaseEntity

        entity.setId(t.getId());
        entity.setIsbn(t.getIsbn());
        entity.setAdminId(t.getAdminId());
        entity.setBorrowerId(t.getBorrowerId());
        entity.setBorrowerDate(t.getBorrowerDate());
        entity.setReturnDate(t.getReturnDate());
        return entity;
    }

    public static Ticket entity2Model(TicketEntity entity) {
        Ticket t = new Ticket();
        t.setId(entity.getId());
        t.setIsbn(entity.getIsbn());
        t.setAdminId(entity.getAdminId());
        t.setBorrowerId(entity.getBorrowerId());
        t.setBorrowerDate(entity.getBorrowerDate());
        t.setReturnDate(entity.getReturnDate());
        return t;
    }
}
