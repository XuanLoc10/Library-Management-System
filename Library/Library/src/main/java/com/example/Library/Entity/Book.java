package com.example.Library.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer isbn;
    private String title;
    private String author;
    private String typeOfBook;
    private String publisher;
    //Hiem thi thang-nam xuat ban cuon sach 2012-10
    private String publishingYear;
    private String url;
    private String decription;
    private boolean status;

    public Book(){

    }

    public Book(Integer isbn, String title, String author, String typeOfBook, String publisher, String publishingYear, String url, String decription, boolean status) {

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.typeOfBook = typeOfBook;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.url = url;
        this.decription = decription;
        this.status = status;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(String ibsn) {
        this.isbn = isbn;
    }

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
