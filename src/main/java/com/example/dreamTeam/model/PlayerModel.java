package com.example.dreamTeam.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {

    private String firstname;
    private String lastname;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Position position;

}
