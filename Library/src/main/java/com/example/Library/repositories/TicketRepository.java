package com.example.Library.repositories;

import com.example.Library.entities.TicketEntity;
import com.example.Library.models.Ticket;
import feign.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}

