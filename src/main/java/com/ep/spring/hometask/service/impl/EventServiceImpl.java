package com.ep.spring.hometask.service.impl;

import com.ep.spring.hometask.domain.Event;
import com.ep.spring.hometask.repository.EventRepository;
import com.ep.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class EventServiceImpl implements EventService {

    private EventRepository repository;

    public EventRepository getRepository() {
        return repository;
    }

    public void setRepository(EventRepository eventRepository) {
        this.repository = eventRepository;
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return repository.getByName(name);
    }

    @Override
    public Event save(@Nonnull Event event) {
        return repository.save(event);
    }

    @Override
    public void remove(@Nonnull Event event) {
        repository.remove(event);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return repository.getById(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return repository.getAll();
    }
}