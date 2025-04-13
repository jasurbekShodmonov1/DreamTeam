package com.example.dreamTeam.repository;

import com.example.dreamTeam.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {

}

