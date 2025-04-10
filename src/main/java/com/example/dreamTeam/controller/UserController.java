package com.example.dreamTeam.controller;

import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.model.PlayerModel;
import com.example.dreamTeam.model.UserModel;
import com.example.dreamTeam.repository.RoleRepository;
import com.example.dreamTeam.repository.UserRepository;
import com.example.dreamTeam.service.RoleService;
import com.example.dreamTeam.service.UserService;
import com.example.dreamTeam.service.impl.RoleServiceImpl;
import com.example.dreamTeam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @GetMapping
    public String listUsers(Model model) {
        List<UserEntity> userModel = userService.getAllUsers();
        model.addAttribute("users", userModel);
        return "users/user_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("users", new UserModel());
        List<RoleEntity> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "users/user_form";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserModel userModel, Model model) {
        userService.createUser(userModel);
        model.addAttribute("success", "User created successfully!");
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        List<RoleEntity> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "users/user_update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute UserModel userModel, @PathVariable Long id, Model model){

        userService.update(id, userModel);
        model.addAttribute("success", "User updated successfully!");
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users";
    }

}
