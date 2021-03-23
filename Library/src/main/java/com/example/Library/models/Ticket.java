package com.example.Library.models;

import java.util.Date;

public class Ticket {
    private Long ticketId;
    private Book book;
    private Long borrowerId;
    private Date borrowerDate;
    private Date returnDate;

    public Long getId() {
        return ticketId;
    }

    public void setId(Long id) {
        this.ticketId = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getBorrowerDate() {
        return borrowerDate;
    }

    public void setBorrowerDate(Date borrowerDate) {
        this.borrowerDate = borrowerDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
