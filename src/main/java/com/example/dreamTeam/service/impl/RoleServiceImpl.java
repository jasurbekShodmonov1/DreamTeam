package com.example.dreamTeam.service.impl;

import com.example.dreamTeam.entity.RoleEntity;
import com.example.dreamTeam.model.RoleModel;
import com.example.dreamTeam.repository.RoleRepository;
import com.example.dreamTeam.service.RoleService;
import com.example.dreamTeam.util.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RoleServiceImpl  implements RoleService {
    @Autowired
    private  final RoleRepository roleRepository;


    public List<RoleModel> getRoles() {

        var roles = roleRepository.findAll();
        List<RoleModel> roleModels = new ArrayList<>();
        for (RoleEntity role : roles) {
            roleModels.add(RoleMapper.toRoleModel(role));
        }
        return roleModels;
    }


    public void createRole(String roleName) {

            var roleEntity = new RoleEntity();
            roleEntity.setName(roleName);
            roleRepository.save(roleEntity);

    }
}
