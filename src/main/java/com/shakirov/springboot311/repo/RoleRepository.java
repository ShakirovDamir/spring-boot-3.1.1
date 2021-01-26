package com.shakirov.springboot311.repo;

import com.shakirov.springboot311.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
}
