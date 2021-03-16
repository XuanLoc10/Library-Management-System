package com.example.Library.models;

import java.util.Date;

public class Ticket {
    private Long ticketId;
    private Long isbn;
    private Long borrowerId;
    private Date borrowerDate;
    private Date returnDate;

    public Long getId() {
        return ticketId;
    }

    public void setId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
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
