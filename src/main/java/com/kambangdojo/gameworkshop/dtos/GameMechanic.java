package com.kambangdojo.gameworkshop.dtos;

import lombok.Data;

@Data
public class GameMechanic {

    private long id;
    private long gameId;
    private long userId;
    private String gameMechanic;
}
