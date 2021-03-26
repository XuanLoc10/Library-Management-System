package com.example.Library.models;

import java.util.Date;

public class FormTicket {
    private Long Id;
    private Long bookId;
    private Long borrowerId;
    private Date borrowerDate;
    private Date returnDate;

    public Long getId() {
        return Id;
    }

    public void setId(Long ticketId) {
        this.Id = ticketId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
