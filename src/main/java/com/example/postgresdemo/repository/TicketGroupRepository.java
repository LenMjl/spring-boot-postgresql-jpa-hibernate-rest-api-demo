package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.TicketGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketGroupRepository extends JpaRepository<TicketGroup, Integer> {

    Optional<TicketGroup> findByIdTicket(Integer idTicket);

    @Query(value = "SELECT * FROM ticketgroup", nativeQuery = true)
    List<TicketGroup> findAllTicketGroups();

}
