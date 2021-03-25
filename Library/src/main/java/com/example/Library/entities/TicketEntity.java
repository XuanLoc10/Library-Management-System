package com.example.Library.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class TicketEntity extends AbstractBaseEntity {
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="book_id")
    private BookEntity book;
    @Column
    private Long borrowerId;
    @Column
    private Date borrowerDate;
    @Column
    private Date returnDate;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
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
