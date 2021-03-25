package com.example.Library.repositories;

import com.example.Library.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


import java.util.List;

@EnableJpaRepositories
public interface BookRepository extends JpaRepository<BookEntity, Long>  {
    BookEntity findByTitle(String title);

    @Query(value = "select b.* from Book b where b.status = true", nativeQuery = true)
    List<BookEntity> findByActive();

    @Query(value = "UPDATE book SET status = true WHERE id = :id", nativeQuery = true)
    void changeStatus(@Param("id") Long id);

    @Query(value="select b.* from Book b where b.title= :title", nativeQuery=true)
    List<BookEntity> getBookByTitle(@Param("title") String title);
}

