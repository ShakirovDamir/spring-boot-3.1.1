package com.shakirov.springboot311.service;

import com.shakirov.springboot311.model.User;
import com.shakirov.springboot311.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name);
    }

    @Override
    public void update(User user) { userRepository.save(user); }

    @Override
    public void add(User user) { userRepository.save(user); }

    @Override
    public void delete(User user) {userRepository.delete(user); }

    @Override
    public Iterable<User> listUsers() { return userRepository.findAll(); }

    @Override
    public Optional<User> getUserById(Long id) { return userRepository.findById(id); }
}
