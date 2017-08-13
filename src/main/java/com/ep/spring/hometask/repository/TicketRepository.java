package com.ep.spring.hometask.repository;

import com.ep.spring.hometask.domain.Ticket;

import java.util.Collection;

public interface TicketRepository {
    Collection<Ticket> getAll();

}
