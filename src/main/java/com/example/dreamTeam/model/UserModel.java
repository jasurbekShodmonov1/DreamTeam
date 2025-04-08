package com.example.dreamTeam.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private  String username;
    private  String password;
    private List<Long> roleIds;

}
