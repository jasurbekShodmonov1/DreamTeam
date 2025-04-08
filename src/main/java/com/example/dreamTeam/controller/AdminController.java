package com.example.dreamTeam.controller;

import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.repository.RoleRepository;
import com.example.dreamTeam.repository.UserRepository;
import com.example.dreamTeam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @GetMapping("/users/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("allRoles", roleRepository.findAll());
        return "admin/user_form";
    }

    @PostMapping("/users/create")
    public String saveUser(@ModelAttribute UserEntity user, @RequestParam List<Long> roleIds) {
        Set<RoleEntity> selectedRoles = new HashSet<>(roleRepository.findAllById(roleIds));
        user.setRoles(selectedRoles);
        userService.saveUser(user); // password gets hashed
        return "redirect:/admin/users";
    }

    @GetMapping("/roles")
    public String showRoles(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/roles";
    }

    @GetMapping("/roles/create")
    public String createRoleForm(Model model) {
        model.addAttribute("role", new RoleEntity());
        return "admin/role_form";
    }

    @PostMapping("/roles/create")
    public String saveRole(@ModelAttribute RoleEntity role) {
        roleRepository.save(role);
        return "redirect:/admin/roles";
    }
}
