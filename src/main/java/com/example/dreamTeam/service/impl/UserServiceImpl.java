package com.example.dreamTeam.service.impl;

import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.model.UserModel;
import com.example.dreamTeam.repository.RoleRepository;
import com.example.dreamTeam.repository.UserRepository;
import com.example.dreamTeam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();  // Return all users
    }

    public UserEntity createUser(UserModel userModel) {
        Set<RoleEntity> roles = new HashSet<>();
        for (String roleName : userModel.getRoles()) {
            RoleEntity role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }

        UserEntity user = new UserEntity();
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRoles(roles);

        return userRepository.save(user);
    }

//    public void update(Long id, UserModel model){
//        UserEntity userEntity = userRepository.findById(model.getId()).orElseThrow();
//        userEntity.setUsername(model.getUsername());
//        userEntity.setRoles(model.getRoles());
//    }



}
