package com.example.dreamTeam.repository;

import com.example.dreamTeam.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
//    Optional<UserEntity> findByUsername(String username);
@Query(value = "select u from UserEntity u where u.username=:username")
Optional<UserEntity> findByUserName(@Param("username") String username);
}

