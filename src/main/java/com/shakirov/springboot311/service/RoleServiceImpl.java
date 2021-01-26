package com.shakirov.springboot311.service;

import com.shakirov.springboot311.model.Role;
import com.shakirov.springboot311.repo.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRoles(Set<Role> roles) { roleRepository.saveAll(roles); }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role> iter = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iter.forEach(role -> set.add(role));
        return set;
    }
}
