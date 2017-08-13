package com.ep.spring.hometask.repository.mock;

import com.ep.spring.hometask.domain.Event;
import com.ep.spring.hometask.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EventRepositoryMockImpl implements EventRepository {
    private static final Logger log = LoggerFactory.getLogger(EventRepositoryMockImpl.class);


    private Map<Long, Event> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    {
        MockDB.EVENT_LIST.forEach(event -> save(event));
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        log.info("getEventByEmail {}", name);
        return repository.values().stream()
                .filter(u -> name.equals(u.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Event save(@Nonnull Event event) {
        log.info("save {}", event);
        if (event.getId() == null) {
            event.setId(counter.incrementAndGet());
        }
        repository.put(event.getId(), event);
        return event;
    }

    @Override
    public void remove(@Nonnull Event event) {
        log.info("remove {}", event);
        repository.remove(event.getId());
    }

    @Override
    public Event getById(@Nonnull Long id) {

        return repository.get(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        log.info("getAll");
        return Collections.unmodifiableCollection(repository.values());
    }
}
