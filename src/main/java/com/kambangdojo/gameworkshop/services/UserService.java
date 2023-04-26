package com.kambangdojo.gameworkshop.services;

import com.kambangdojo.gameworkshop.dtos.User;
import com.kambangdojo.gameworkshop.models.UserModel;
import com.kambangdojo.gameworkshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String register(User userData) {

        UserModel newUser = new UserModel();
        newUser.setUsername(userData.getUsername());
        newUser.setEmail(userData.getEmail());
        newUser.setPassword(userData.getPassword());
        newUser.setId(userData.getId());
        System.out.println("Printing user data + " + newUser.toString());

        this.userRepository.save(newUser);
        return HttpStatus.CREATED.toString();
    }

    public Iterable<UserModel> getUsers() {
        var users = this.userRepository.findAll();
        return users;
    }
}
