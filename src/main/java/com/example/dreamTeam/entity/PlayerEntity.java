package com.example.dreamTeam.entity;


import com.example.dreamTeam.model.Position;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String firstname;
    private String lastname;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Position position;
}
