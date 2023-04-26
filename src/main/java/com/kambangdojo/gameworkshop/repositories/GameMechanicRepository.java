package com.kambangdojo.gameworkshop.repositories;

import com.kambangdojo.gameworkshop.models.GameMechanicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameMechanicRepository extends JpaRepository<GameMechanicModel,Long> {
}
