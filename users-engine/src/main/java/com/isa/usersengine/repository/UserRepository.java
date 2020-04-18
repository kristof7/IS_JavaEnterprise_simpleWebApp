package com.isa.usersengine.repository;

import com.isa.usersengine.domain.User;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

@Local
public interface UserRepository {

    void save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);

    List<User> findAll();
}