package com.example.clientapp.controller;

import com.example.clientapp.model.User;
import com.example.clientapp.model.Users;
import com.example.clientapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private UserService userService;

    public ClientController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users-from-client")
    public ResponseEntity<Users> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/findTheEldest")
    public ResponseEntity<User> findTheEldest() {
        return new ResponseEntity<>(userService.findTheEldest(), HttpStatus.OK);
    }
}
