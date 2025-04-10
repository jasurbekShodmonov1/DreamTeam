package com.example.dreamTeam.util;

import com.example.dreamTeam.entity.PlayerEntity;
import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.model.PlayerModel;
import com.example.dreamTeam.model.RoleModel;

public class RoleMapper {
    public static RoleModel toRoleModel(RoleEntity roleEntity){
        var roleModel=new RoleModel();
        roleModel.setName(roleEntity.getName());

        return roleModel;
    }

    public static RoleEntity toRoleEntity(RoleModel roleModel){
        var roleEntity=new RoleEntity();
        roleEntity.setName(roleModel.getName());

        return roleEntity;
    }
}
