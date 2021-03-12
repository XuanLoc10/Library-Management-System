package com.example.Library.entities;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity extends AbstractBaseEntity {
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String typeOfBook;
    @Column
    private String publisher;
    //Hiem thi thang-nam xuat ban cuon sach 2012-10
    @Column
    private String publishingYear;
    @Column
    private String url;
    @Column
    private String decription;
    @Column
    private boolean status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
