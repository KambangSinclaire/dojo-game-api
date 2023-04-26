package com.kambangdojo.gameworkshop.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name = "GameMechanic")
@RequiredArgsConstructor
@Data
public class GameMechanicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private long gameId;

    @Column
    private long userId;

    @Column
    private String gameMechanic;

}
