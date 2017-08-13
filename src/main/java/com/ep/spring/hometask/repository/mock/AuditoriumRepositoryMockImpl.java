package com.ep.spring.hometask.repository.mock;

import com.ep.spring.hometask.domain.Auditorium;
import com.ep.spring.hometask.repository.AuditoriumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class AuditoriumRepositoryMockImpl implements AuditoriumRepository {
    private static final Logger log = LoggerFactory.getLogger(EventRepositoryMockImpl.class);


    private Map<Long, Auditorium> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    {
        MockDB.AUDITORIUM_LIST.forEach(auditorium -> repository.put(counter.incrementAndGet(), auditorium));
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        log.info("getEventByEmail {}", name);
        return repository.values().stream()
                .filter(u -> name.equals(u.getName()))
                .findFirst()
                .orElse(null);
    }
    
    @Nullable
    @Override
    public Set<Auditorium> getAll() {
        log.info("getAll");
        return Collections.unmodifiableSet(new HashSet<>(repository.values()));
    }
 
}
