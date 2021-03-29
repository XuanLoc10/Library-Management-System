package com.example.Library.repositories;

import com.example.Library.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface BookRepository extends JpaRepository<BookEntity, Long>  {
    BookEntity findByTitle(String title);

    @Query(value = "select b.* from Book b where b.status = true", nativeQuery = true)
    List<BookEntity> findByActive();

    //KeySearch
    @Query(value = "select b.* from Book b where b.author = :author", nativeQuery = true)
    List<BookEntity> findByAuthor(String author);
}

