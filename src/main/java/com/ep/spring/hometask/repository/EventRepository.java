package com.ep.spring.hometask.repository;

import com.ep.spring.hometask.domain.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface EventRepository extends AbstractDomainObjectRepository<Event>{
    /**
     * Finding event by email in storage
     *
     * @param name
     *            Email of the event
     * @return found event or <code>null</code>
     */
    @Nullable Event getByName(@Nonnull String name);

}
