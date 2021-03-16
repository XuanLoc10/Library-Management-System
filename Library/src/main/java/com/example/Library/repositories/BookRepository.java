package com.example.Library.repositories;

import com.example.Library.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    BookEntity findByTitle(String title);
}

