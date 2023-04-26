package com.kambangdojo.gameworkshop.controllers;

import com.kambangdojo.gameworkshop.dtos.Game;
import com.kambangdojo.gameworkshop.dtos.ResponsePayload;
import com.kambangdojo.gameworkshop.models.GameModel;
import com.kambangdojo.gameworkshop.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    private @ResponseBody ResponsePayload addGame(@RequestBody Game payload){
    return this.gameService.addGame(payload);
    }

    @GetMapping(path="{id}")
    private @ResponseBody Optional<GameModel> getGameById(@PathVariable("id") long id){
        return this.gameService.getGameById(id);
    }

    @GetMapping(path="user/{id}")
    private @ResponseBody List<GameModel> getUserNames(@PathVariable("id") long id){
        return this.gameService.getAllUserGames(id);
    }

    @GetMapping
    private @ResponseBody List<GameModel> getGames(){
        return this.gameService.getAllGames();
    }

    @DeleteMapping(path = "{id}")
    private @ResponseBody ResponsePayload deleteGame(@PathVariable("id") long gameId){
        return this.gameService.deleteGame(gameId);
    }

    @PutMapping("/{id}")
    private @ResponseBody ResponsePayload updateGame(Game game, @PathVariable("id") long id){
        return this.gameService.updateGame(game,id);
    }
}
