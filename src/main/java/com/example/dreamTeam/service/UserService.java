package com.example.dreamTeam.service;

import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();
    UserEntity createUser(UserModel userModel);
    void update(Long id, UserModel model);

}
