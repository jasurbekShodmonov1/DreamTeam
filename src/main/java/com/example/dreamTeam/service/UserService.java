package com.example.dreamTeam.service;

import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.model.UserDto;
import com.example.dreamTeam.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();
    List<UserDto> getUsers();
    UserDto getUser(Long id);
    UserEntity createUser(UserModel userModel);
    UserModel getUserById(Long id);

    void update(Long id, UserModel model);
    void delete(Long id);
}
