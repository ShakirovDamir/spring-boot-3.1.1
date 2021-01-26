package com.shakirov.springboot311.service;

import com.shakirov.springboot311.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    void update(User user);
    void add(User user);
    void delete(User user);
    Iterable<User> listUsers();
    Optional<User> getUserById(Long id);

}
