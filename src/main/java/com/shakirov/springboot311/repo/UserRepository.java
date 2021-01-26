package com.shakirov.springboot311.repo;

import com.shakirov.springboot311.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);


}
