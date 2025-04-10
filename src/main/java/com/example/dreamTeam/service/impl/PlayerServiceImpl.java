package com.example.dreamTeam.service.impl;

import com.example.dreamTeam.entity.PlayerEntity;
import com.example.dreamTeam.model.PlayerModel;
import com.example.dreamTeam.repository.PlayerRepository;
import com.example.dreamTeam.service.PlayerService;
import com.example.dreamTeam.util.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public List<PlayerEntity> getAllEntities() {
        return playerRepository.findAll();  // Retrieves all PlayerEntity records from the database
    }

    @Override
    public List<PlayerModel> getPlayers() {

        var players = playerRepository.findAll();
        List<PlayerModel> bookModels = new ArrayList<>();
        for (PlayerEntity player : players) {
            bookModels.add(PlayerMapper.toPlayerModel(player));
        }
        return bookModels;
    }

    @Override
    public PlayerModel getPlayerById(Long id) {
        PlayerEntity player = playerRepository.findById(id).orElseThrow();
        return new PlayerModel(player.getId(), player.getFirstname(), player.getLastname(), player.getAge(), player.getPosition());
    }

    @Override
    public void save(PlayerModel model) {
        var playerEntity = PlayerMapper.toPlayerEntity(model);
        playerRepository.save(playerEntity);
    }


    @Override
    public void update(Long id, PlayerModel model) {

        PlayerEntity entity = playerRepository.findById(model.getId()).orElseThrow();
        entity.setFirstname(model.getFirstname());
        entity.setLastname(model.getLastname());
        entity.setAge(model.getAge());
        entity.setPosition(model.getPosition());
        playerRepository.save(entity);
    }


    @Override
    public void delete(Long id){
        playerRepository.deleteById(id);
    }
}
