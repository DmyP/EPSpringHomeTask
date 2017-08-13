package com.ep.spring.hometask.service.impl;

import com.ep.spring.hometask.domain.Event;
import com.ep.spring.hometask.domain.Ticket;
import com.ep.spring.hometask.domain.User;
import com.ep.spring.hometask.repository.TicketRepository;
import com.ep.spring.hometask.service.BookingService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private TicketRepository repository;
    public static final double MAX_DISCOUNT = 0.25;


    public TicketRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketRepository repository) {
        this.repository = repository;
    }

    /**
     * Getting price when buying all supplied seats for particular event
     *
     * @param event
     *            Event to get base ticket price, vip seats and other
     *            information
     * @param dateTime
     *            Date and time of event air
     * @param user
     *            User that buys ticket could be needed to calculate discount.
     *            Can be <code>null</code>
     * @param seats
     *            Set of seat numbers that user wants to buy
     * @return total price
     */
    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        Collection<Ticket> tickets = repository.getAll();
        Set<Ticket> ticketSet = tickets.stream()
                .filter(ticket -> ticket.getUser().equals(user))
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> ticket.getDateTime().equals(dateTime))
                .filter(ticket -> seats.contains(ticket.getSeat())).collect(Collectors.toSet());
        int totalNumberUserTickets = ticketSet.size() + user.getTickets().size();
        double currentDiscount = totalNumberUserTickets > MAX_DISCOUNT ? MAX_DISCOUNT : totalNumberUserTickets ;

        return event.getBasePrice() - currentDiscount * event.getBasePrice();
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {

    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return null;
    }

    @Override
    public Collection<Ticket> getAll() {
        return repository.getAll();
    }
}
