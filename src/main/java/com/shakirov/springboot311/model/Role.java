package com.shakirov.springboot311.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() { }

    public Role(String role) {
        if (role.equals("ROLE_ADMIN")) {
            this.id = 1L;
        } else if (role.equals("ROLE_USER")) {
            this.id = 2L;
        }
        this.role = role;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }


// метод GrantedAuthority
    @Override
    public String getAuthority() { return role; }

    @Override
    public String toString() { return role; }
}
