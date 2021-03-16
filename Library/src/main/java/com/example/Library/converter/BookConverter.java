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
        entity.setPublishingYear(b.getPublishingYear());
        entity.setDescription(b.getDescription());
        entity.setStatus(b.isStatus());
        return entity;
    }

    public static Book entity2Model(BookEntity entity) {
        Book u = new Book();
        u.setId(entity.getId());
        u.setTitle(entity.getTitle());
        u.setAuthor(entity.getAuthor());
        u.setPublishingYear(entity.getPublishingYear());
        u.setDescription(entity.getDescription());
        u.setStatus(entity.isStatus());
        return u;
    }
}
