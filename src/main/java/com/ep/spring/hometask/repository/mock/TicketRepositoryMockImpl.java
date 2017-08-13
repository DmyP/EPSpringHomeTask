package com.ep.spring.hometask.repository.mock;

import com.ep.spring.hometask.domain.Ticket;
import com.ep.spring.hometask.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TicketRepositoryMockImpl implements TicketRepository {
    private static final Logger log = LoggerFactory.getLogger(TicketRepositoryMockImpl.class);

    private Map<Long, Ticket> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    {
        MockDB.TICKET_LIST.forEach(ticket -> repository.put(counter.incrementAndGet(), ticket));
    }


    public Collection<Ticket> getAll() {
        log.info("getAll");
        return Collections.unmodifiableCollection(repository.values());
    }
}
