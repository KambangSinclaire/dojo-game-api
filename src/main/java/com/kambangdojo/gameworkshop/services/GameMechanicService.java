package com.kambangdojo.gameworkshop.services;

import com.kambangdojo.gameworkshop.dtos.ResponsePayload;
import com.kambangdojo.gameworkshop.models.GameMechanicModel;
import com.kambangdojo.gameworkshop.repositories.GameMechanicRepository;
import com.kambangdojo.gameworkshop.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameMechanicService {

    @Autowired
    private GameMechanicRepository gameMechanicRepository;

    public ResponsePayload addGameMechanic(GameMechanicModel payload){
        var newGameMechanic = new GameMechanicModel();
        newGameMechanic.setGameId(payload.getGameId());
        newGameMechanic.setGameMechanic(payload.getGameMechanic());
        newGameMechanic.setUserId(payload.getUserId());

        this.gameMechanicRepository.save(newGameMechanic);
        return this.prepareResponse("Game Mechanic added successfully",HttpStatus.CREATED);
    }

    public ResponsePayload deleteMechanic(long gameMechanicId){
        this.gameMechanicRepository.deleteById(gameMechanicId);
        return this.prepareResponse("Game Mechanic deleted successfully",HttpStatus.OK);
    }

    public ResponsePayload updateGameMechanic(GameMechanicModel gameMechanic, long id){
       var foundGameMechanic = this.gameMechanicRepository.findById(id);
       if(!foundGameMechanic.isEmpty()){
           //
       }
       return this.prepareResponse("Mechanic not found",HttpStatus.NOT_FOUND);
  }

    public List<GameMechanicModel> getAllGameMechanics(){
        return this.gameMechanicRepository.findAll();
    }
    public ResponsePayload prepareResponse(String message, HttpStatus status){
        // prepare response
        var response= new ResponsePayload();
        response.setStatusCode(status);
        response.setMessage(message);
        return response;
    }

}
