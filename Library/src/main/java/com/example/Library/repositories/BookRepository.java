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

    @Query(value = " select b.* from Book b where b.status = true AND (b.id like %:key% OR b.author like %:key% OR b.title like %:key% OR b.publishing_year like %:key% OR b.description like %:key%)", nativeQuery = true)
    List<BookEntity> findBySearch(String key);
}

