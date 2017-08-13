package com.ep.spring.hometask.repository;

import com.ep.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public interface AuditoriumRepository{

    /**
     * Getting all Auditorium from storage
     *
     * @return collection of Auditorium
     */
    @Nullable public Set<Auditorium> getAll();

    /**
     * Finding Auditorium by name in storage
     *
     * @param name
     *            Name of the Auditorium
     * @return found Auditorium or <code>null</code>
     */
    @Nullable Auditorium getByName(@Nonnull String name);

}
