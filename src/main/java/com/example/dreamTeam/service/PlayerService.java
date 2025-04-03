package com.example.dreamTeam.service;

import com.example.dreamTeam.entity.PlayerEntity;
import com.example.dreamTeam.model.PlayerModel;

import java.util.List;

public interface PlayerService {
    List<PlayerModel> getPlayers();
    void save(PlayerModel model);

}
