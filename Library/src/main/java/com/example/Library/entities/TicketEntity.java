package com.example.Library.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class TicketEntity extends AbstractBaseEntity {
    //Cac column isbn la khoa ngoai cua table book
    //Cac column borrowerId la khoa ngoai cua table user
    @Column
    private Long isbn;
    @Column
    private Long borrowerId;
    @Column
    private Date borrowerDate;
    @Column
    private Date returnDate;

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
