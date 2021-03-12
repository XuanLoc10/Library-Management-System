package com.example.Library.converter;

import com.example.Library.entities.BookEntity;
import com.example.Library.models.Book;

public class BookConverter {
    public static BookEntity model2Entity(Book b) {
        BookEntity entity = new BookEntity();
        //Su dung phuong thuc set, get AbstractBaseEntity

        entity.setId(b.getId());
        entity.setTitle(b.getTitle());
        entity.setAuthor(b.getAuthor());
        entity.setPublisher(b.getPublisher());
        entity.setPublishingYear(b.getPublishingYear());
        entity.setDecription(b.getDecription());
        entity.setUrl(b.getUrl());
        entity.setStatus(b.isStatus());
        entity.setTypeOfBook(b.getTypeOfBook());
        //entity.setId(u.getId());
        //entity.setName(u.getName());
        //entity.setEmail(u.getEmail());
        return entity;
    }

    public static Book entity2Model(BookEntity entity) {
        Book u = new Book();
        u.setId(entity.getId());
        u.setTitle(entity.getTitle());
        u.setAuthor(entity.getAuthor());
        u.setPublisher(entity.getPublisher());
        u.setPublishingYear(entity.getPublishingYear());
        u.setDecription(entity.getDecription());
        u.setUrl(entity.getUrl());
        u.setStatus(entity.isStatus());
        u.setTypeOfBook(entity.getTypeOfBook());
        return u;
    }
}
