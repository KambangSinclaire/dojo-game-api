package com.kambangdojo.gameworkshop.dtos;


import lombok.Data;

@Data
public class Game {

    private long id;
    private String name;
    private String genre;
    private String description;
}
