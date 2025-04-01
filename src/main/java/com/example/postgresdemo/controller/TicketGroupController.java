package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.TicketGroup;
import com.example.postgresdemo.repository.TicketGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketgroups")
public class TicketGroupController {

    @Autowired
    private TicketGroupRepository ticketGroupRepository;

    // Recupera tutti i TicketGroup in modo paginato
    @GetMapping
    public Page<TicketGroup> getAllTickets(Pageable pageable) {
        return ticketGroupRepository.findAll(pageable);
    }

    // Recupera tutti i TicketGroup senza paginazione
    @GetMapping("/all")
    public List<TicketGroup> getAllTicketGroups() {
        return ticketGroupRepository.findAllTicketGroups();
    }

    // Recupera un TicketGroup in base all'id del ticket
    @GetMapping("/{id}")
    public TicketGroup getTicketGroupByTicketId(@PathVariable Integer id) {
        return ticketGroupRepository.findByIdTicket(id)
                .orElseThrow(() -> new ResourceNotFoundException("TicketGroup not found with id_ticket " + id));
    }
}
