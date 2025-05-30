package com.example.dreamTeam.util;

import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.entity.UserEntity;
import com.example.dreamTeam.model.RoleModel;
import com.example.dreamTeam.model.UserModel;
import com.example.dreamTeam.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserMapper {






    public static Set<RoleEntity> changeRole(UserModel model, RoleRepository roleRepository ){
        Set<RoleEntity> roles = new HashSet<>();
        for (String roleName : model.getRoles()) {
            RoleEntity role =roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }
        return roles;
    }
}
