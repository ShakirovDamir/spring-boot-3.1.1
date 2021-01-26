package com.shakirov.springboot311.service;

import com.shakirov.springboot311.model.Role;


import java.util.Set;

public interface RoleService  {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
}
