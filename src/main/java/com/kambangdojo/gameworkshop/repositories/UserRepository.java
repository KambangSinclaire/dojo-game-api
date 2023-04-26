package com.kambangdojo.gameworkshop.repositories;

import com.kambangdojo.gameworkshop.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {
}
