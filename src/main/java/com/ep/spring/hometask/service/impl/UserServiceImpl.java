package com.ep.spring.hometask.service.impl;

import com.ep.spring.hometask.domain.User;
import com.ep.spring.hometask.repository.UserRepository;
import com.ep.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return repository.getUserByEmail(email);
    }

    @Override
    public User save(@Nonnull User user) {
        return repository.save(user);
    }

    @Override
    public void remove(@Nonnull User user) {
        repository.remove(user);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return repository.getById(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return repository.getAll();
    }
}
