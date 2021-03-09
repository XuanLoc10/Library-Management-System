package com.example.Library.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ticketId;
    private  Integer borrowerId;
    private Integer adminId;
    @Id
    private String isbn;
    private Date borrowerDate;
    private Date returnDate;
    public Ticket(){

    }
    public Ticket(Integer ticketId, Integer borrowerId, Integer adminId, String isbn, Date borrowerDate, Date returnDate) {
        this.ticketId = ticketId;
        this.borrowerId = borrowerId;
        this.adminId = adminId;
        this.isbn = isbn;
        this.borrowerDate = borrowerDate;
        this.returnDate = returnDate;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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
