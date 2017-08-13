package com.ep.spring.hometask.repository.mock;



import com.ep.spring.hometask.domain.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class MockDB {
    static final List<Auditorium> AUDITORIUM_LIST = Arrays.asList(
            new Auditorium("Auditorium 1", 5),
            new Auditorium("Auditorium 2", 5)
    );

    static final List<Event> EVENT_LIST = Arrays.asList(
            new Event("Event 1", 0, EventRating.LOW),
            new Event("Event 2", 100, EventRating.HIGH)
    );

    static final List<User> USER_LIST = Arrays.asList(
            new User( "User1_firstName", "User1_lastName", "User1@ep.com"),
            new User( "User2_firstName", "User2_lastName", "User2@ep.com"),
            new User( "User3_firstName", "User3_lastName", "User3@ep.com"),
            new User( "User4_firstName", "User4_lastName", "User4@ep.com"),
            new User( "User5_firstName", "User5_lastName", "User5@ep.com")
    );

    static final List<Ticket> TICKET_LIST = Arrays.asList(
            new Ticket(USER_LIST.get(0), EVENT_LIST.get(0), LocalDateTime.now(), 1),
            new Ticket(USER_LIST.get(1), EVENT_LIST.get(1), LocalDateTime.now(), 2),
            new Ticket(USER_LIST.get(2), EVENT_LIST.get(1), LocalDateTime.now(), 3),
            new Ticket(USER_LIST.get(3), EVENT_LIST.get(1), LocalDateTime.now(), 4),
            new Ticket(USER_LIST.get(4), EVENT_LIST.get(1), LocalDateTime.now(), 5)
    );
}


