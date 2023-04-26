package com.kambangdojo.gameworkshop.controllers;

import com.kambangdojo.gameworkshop.dtos.ResponsePayload;
import com.kambangdojo.gameworkshop.models.GameMechanicModel;
import com.kambangdojo.gameworkshop.services.GameMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/game-mechanic")
public class GameMechanicController {

    @Autowired
    private GameMechanicService gameMechanicService;

    @PostMapping
    ResponsePayload addGameMechanic(@RequestBody GameMechanicModel payload){
    return this.gameMechanicService.addGameMechanic(payload);
    }

    @GetMapping
    List<GameMechanicModel> getAllGameMechanics(){
        return this.gameMechanicService.getAllGameMechanics();
    }

    @DeleteMapping("{id}")
    ResponsePayload deleteGameMechanic(@PathVariable("id") long id){
        return this.gameMechanicService.deleteMechanic(id);
    }
}
