package com.example.Library.repositories;

import com.example.Library.entities.TicketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TicketRepository extends CrudRepository<TicketEntity, Long> {

    //Query so sach ma 1 nguoi muon
    @Query(value = "select b.* from Book b where b.status = true", nativeQuery = true)
    List<TicketEntity> ListBookBorrower();
}

