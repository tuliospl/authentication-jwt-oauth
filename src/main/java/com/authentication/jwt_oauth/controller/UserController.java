package com.authentication.jwt_oauth.controller;

import com.authentication.jwt_oauth.model.User;
import com.authentication.jwt_oauth.security.MyToken;
import com.authentication.jwt_oauth.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private IUserService service;

    public UserController(IUserService service) {
        super();
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(201).body(service.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<MyToken> loging(@RequestBody User user){
        return ResponseEntity.ok(service.userLogin(user));
    }
}
