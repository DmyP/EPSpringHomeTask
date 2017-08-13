package com.ep.spring.hometask.repository.mock;

import com.ep.spring.hometask.domain.User;
import com.ep.spring.hometask.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UserRepositoryMockImpl implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryMockImpl.class);

    private Map<Long, User> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    // Enable with real DB
    // private static final Comparator<User> USER_COMPARATOR = Comparator.comparing(User::getFirstName).thenComparing(User::getLastName);

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        log.info("getUserByEmail {}", email);
        return repository.values().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(@Nonnull User user) {
        log.info("save {}", user);
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public void remove(@Nonnull User user) {
        log.info("remove {}", user);
        repository.remove(user.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {

        return repository.get(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        log.info("getAll");
        return Collections.unmodifiableCollection(repository.values());
    }
}
