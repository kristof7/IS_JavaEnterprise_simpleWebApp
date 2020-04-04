package com.isa.usersengine.repository;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.storage.UserDb;
import java.util.List;
import java.util.Optional;

public class UserRepositoryBean implements UserRepository {

  @Override
  public void save(User user) {
    UserDb.getRepository().add(user);
  }

  @Override
  public Optional<User> findById(Long id) {
    return findAll().stream()
        .filter(user -> user.getId().equals(id)).findFirst();
  }

  @Override
  public Optional<User> findByLogin(String login) {
    return findAll().stream()
        .filter(user -> user.getLogin().equals(login)).findFirst();
  }

  @Override
  public List<User> findAll() {
    return UserDb.getRepository();
  }
}
