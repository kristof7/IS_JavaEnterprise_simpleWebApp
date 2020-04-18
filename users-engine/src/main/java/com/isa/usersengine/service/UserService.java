package com.isa.usersengine.service;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UserRepository;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserService {

    @EJB
    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
