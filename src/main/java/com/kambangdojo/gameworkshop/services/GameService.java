package com.kambangdojo.gameworkshop.services;
import com.kambangdojo.gameworkshop.dtos.Game;
import com.kambangdojo.gameworkshop.dtos.ResponsePayload;
import com.kambangdojo.gameworkshop.models.GameModel;
import com.kambangdojo.gameworkshop.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public ResponsePayload addGame(Game game){

        var foundGame = this.getGameByName(game.getName());

        if(!foundGame.isEmpty()){
           return this.prepareResponse("Game with name already exists",HttpStatus.BAD_REQUEST);
        }
        // Save new Game
        var newGame = new GameModel();
        newGame.setName(game.getName());
        newGame.setDescription(game.getDescription());
        newGame.setGenre(game.getGenre());

        // Save data to database
        this.gameRepository.save(newGame);

      return this.prepareResponse("New Game registered",HttpStatus.CREATED);
    }

    public Optional<GameModel> getGameById(long id){
        return this.gameRepository.findById(id);
    }

    public Optional<GameModel> getGameByName(String name){
        var foundGame = this.gameRepository
                .findAll()
                .stream()
                .filter(game->game.getName().equals(name))
                .findFirst();
        return foundGame;
    }

    public ResponsePayload updateGame(Game game, long gameId){
        var foundGame = this.getGameById(gameId);
        if(!foundGame.isEmpty()){
            // update game here
        }
        return this.prepareResponse("Game successfully updated",HttpStatus.OK);
    }

    public ResponsePayload deleteGame(long gameId){

        this.gameRepository.deleteById(gameId);

        return this.prepareResponse("Game successfully deleted",HttpStatus.OK);
    }

    public List<GameModel> getAllGames(){
        return this.gameRepository.findAll();
    }

    public List<GameModel> getAllUserGames(long userId){
        return this.gameRepository
                .findAll()
                .stream().filter(game->game.getUserId()==userId)
                .toList();
    }

    public ResponsePayload prepareResponse(String message, HttpStatus status){
        // prepare response
        var response= new ResponsePayload();
        response.setStatusCode(status);
        response.setMessage(message);
        return response;
    }
}
