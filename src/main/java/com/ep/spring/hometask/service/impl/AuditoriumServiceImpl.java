package com.ep.spring.hometask.service.impl;

import com.ep.spring.hometask.domain.Auditorium;
import com.ep.spring.hometask.repository.AuditoriumRepository;
import com.ep.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class AuditoriumServiceImpl implements AuditoriumService {
    private AuditoriumRepository repository;

    public AuditoriumRepository getRepository() {
        return repository;
    }

    public void setRepository(AuditoriumRepository repository) {
        this.repository = repository;
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return repository.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return repository.getByName(name);
    }
}
