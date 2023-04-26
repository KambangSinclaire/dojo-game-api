package com.kambangdojo.gameworkshop.repositories;

import com.kambangdojo.gameworkshop.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel,Long> {
    GameModel findByName(String name);
}
