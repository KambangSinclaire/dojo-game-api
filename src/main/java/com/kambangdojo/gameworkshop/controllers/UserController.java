package com.kambangdojo.gameworkshop.controllers;

import com.kambangdojo.gameworkshop.dtos.User;
import com.kambangdojo.gameworkshop.models.UserModel;
import com.kambangdojo.gameworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path="/register")
    private @ResponseBody String register(@RequestBody User payload){
        var response = this.userService.register(payload);
        return response;
    }

    @PostMapping("login")
    private String login(){
        return "";
    }

    @GetMapping()
    private @ResponseBody Iterable<UserModel> getUsers(){
        var users = userService.getUsers();
        return users;
    }
}
