package com.example.Library.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class TicketEntity extends AbstractBaseEntity {
    //Cac Column isbn la khoa ngoai cua table book
    //Cac column adminId, borrower
    @Column
    private Long isbn;
    @Column
    private Long adminId;
    @Column
    private Long borrowerId;
    @Column
    private Date borrowerDate;
    @Column
    private Date returnDate;
    /*
    public TicketEntity(){

    }
    public TicketEntity(Integer ticketId, Integer borrowerId, Integer adminId, String isbn, Date borrowerDate, Date returnDate) {
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
    */
    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
