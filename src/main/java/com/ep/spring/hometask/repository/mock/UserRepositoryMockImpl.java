package com.ep.spring.hometask.repository.mock;

import com.ep.spring.hometask.domain.User;
import com.ep.spring.hometask.repository.UserRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UserRepositoryMockImpl implements UserRepository {

    private Map<Long, User> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    private static final Comparator<User> USER_COMPARATOR = Comparator.comparing(User::getFirstName).thenComparing(User::getLastName);

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return repository.values().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(@Nonnull User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public void remove(@Nonnull User user) {
        repository.remove(user.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return repository.get(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return Collections.unmodifiableCollection(repository.values().stream()
                        .sorted(USER_COMPARATOR).collect(Collectors.toList()));
    }
}
