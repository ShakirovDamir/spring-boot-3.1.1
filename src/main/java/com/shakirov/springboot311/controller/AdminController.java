package com.shakirov.springboot311.controller;


import com.shakirov.springboot311.model.User;
import com.shakirov.springboot311.service.RoleService;
import com.shakirov.springboot311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController (UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String AdminPage(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "admin";
    }

    @GetMapping("/create")
    public String getCreatePage(ModelMap model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        User newUser = user;
        userService.add(newUser);
        return "redirect:/admin";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user);
        return "redirect:/admin";
    }
    
    @PostMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("editUser", user);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/admin";
    }


}
