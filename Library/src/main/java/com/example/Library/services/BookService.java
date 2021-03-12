package com.example.Library.services;

import com.example.Library.converter.BookConverter;
import com.example.Library.entities.BookEntity;
import com.example.Library.models.Book;
import com.example.Library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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
                //.map(UserConverter::entity2Model)
                //Tim cach viet khac
                //Su dung lamda
                .map((BookEntity entity) -> BookConverter.entity2Model(entity))
                //Su dung cach de hieu hon
                .collect(Collectors.toList());
    }
/*
    public Book findById(Long isbn) {

    }



    public Book save(Book newBook) {

    }
*/
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
