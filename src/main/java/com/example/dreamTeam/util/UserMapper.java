package com.example.dreamTeam.util;

import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.model.RoleModel;
import com.example.dreamTeam.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {



//    public static UserModel toUserModel(UserEntity userEntity){
//        var userModel=new UserModel();
//        userModel.setUsername(userEntity.getUsername());
//        userModel.setPassword(userEntity.getPassword());
//        List<Long> roleIds = userEntity.getRoles().stream()
//                .map(RoleEntity::getId)
//                .collect(Collectors.toList());
//
//        userModel.setRoles(roleIds);
//        return userModel;
//    }
}
