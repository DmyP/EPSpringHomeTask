package com.ep.spring.hometask.repository;

import com.ep.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface UserRepository extends AbstractDomainObjectRepository<User>{
    /**
     * Finding user by email in storage
     *
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    @Nullable User getUserByEmail(@Nonnull String email);

}
