package com.example.dreamTeam.repository;

import com.example.dreamTeam.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<PlayerEntity, Long> {

}
