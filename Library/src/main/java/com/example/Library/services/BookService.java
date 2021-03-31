package com.example.Library.services;

import com.example.Library.converter.BookConverter;
import com.example.Library.entities.BookEntity;
import com.example.Library.models.Book;
import com.example.Library.repositories.BookRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .map((BookEntity entity) -> BookConverter.entity2Model(entity))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findById(Long id) {
        BookEntity entity = bookRepository.findById(id).get();
        Book user = BookConverter.entity2Model(entity);
        return user;
    }

    public Book addBook(BookEntity book) {
        BookEntity bookEntity = bookRepository.findByTitle(book.getTitle());
        if (bookEntity == null) {
            book.setStatus(true);
            bookEntity = bookRepository.save(book);
            return BookConverter.entity2Model(bookEntity);
        }
        return null;
    }
    public Book saveBook(BookEntity book) {
        BookEntity bookEntity = bookRepository.findById(book.getId()).get();
        if (bookEntity != null) {
            book.setStatus(true);
            bookEntity = bookRepository.save(book);
            return BookConverter.entity2Model(bookEntity);
        }
        return null;
    }

    @Transactional
    public List<Book> getActive() {
        return StreamSupport
                .stream(bookRepository.findByActive().spliterator(), false)
                .map((BookEntity entity) -> BookConverter.entity2Model(entity))
                .collect(Collectors.toList());
    }

    public List<Book> findBySearch(String key) {
        List<BookEntity> bookEntities = null;
        if(StringUtils.isEmpty(key)){
            bookEntities = bookRepository.findAll();
        }
        else {
            bookEntities = bookRepository.findBySearch(key);
        }
        return StreamSupport
                .stream(bookEntities.spliterator(), false)
                .map((BookEntity entity) -> BookConverter.entity2Model(entity))
                .collect(Collectors.toList());
    }
}
