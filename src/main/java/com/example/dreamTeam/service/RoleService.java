package com.example.dreamTeam.service;

import com.example.dreamTeam.model.RoleModel;

import java.util.List;

public interface RoleService {
    List<RoleModel> getRoles();
    void createRole(String roleName);

}
