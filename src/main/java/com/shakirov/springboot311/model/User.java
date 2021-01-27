package com.shakirov.springboot311.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, surname, department, password;
    private int salary;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() { }

    public User(Long id, String name, String surname, String department, String password, int salary, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.password = password;
        this.salary = salary;
        this.roles = roles;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    public void setPassword(String password) { this.password = password; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    public Set<Role> getRoles() { return roles; }

    public void setRoles(String roles) {
        this.roles = new HashSet<>();
        if (roles.contains("ROLE_ADMIN")) {
            this.roles.add(new Role("ROLE_ADMIN"));
        }
        if (roles.contains("ROLE_USER")) {
            this.roles.add(new Role("ROLE_USER"));
        }
    }

    //методы UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }

    @Override public String getPassword() { return password; }

    @Override
    public String getUsername() { return name; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", roles=" + roles +
                '}';
    }
}
