package com.example.dreamTeam.util;

import com.example.dreamTeam.entity.PlayerEntity;
import com.example.dreamTeam.model.PlayerModel;

public class PlayerMapper {

    public static PlayerModel toPlayerModel(PlayerEntity playerEntity){
        var playerModel=new PlayerModel();
        playerModel.setFirstname(playerEntity.getFirstname());
        playerModel.setLastname(playerEntity.getLastname());
        playerModel.setAge(playerEntity.getAge());
        playerModel.setPosition(playerEntity.getPosition());
        return playerModel;
    }

    public static PlayerEntity toPlayerEntity(PlayerModel playerModel){
        var playerEntity=new PlayerEntity();
        playerEntity.setFirstname(playerModel.getFirstname());
        playerEntity.setLastname(playerModel.getLastname());
        playerEntity.setAge(playerModel.getAge());
        playerEntity.setPosition(playerModel.getPosition());
        return playerEntity;
    }
}
