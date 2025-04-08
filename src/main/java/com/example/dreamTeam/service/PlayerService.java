package com.example.dreamTeam.service;

import com.example.dreamTeam.entity.PlayerEntity;
import com.example.dreamTeam.model.PlayerModel;

import java.util.List;

public interface PlayerService {
    List<PlayerEntity> getAllEntities();

    List<PlayerModel> getPlayers();
    PlayerModel getPlayerById(Long id);
    void save(PlayerModel model);
    void update(Long id, PlayerModel model);
    void delete(Long id);


//    void update(PlayerModel model);
}
