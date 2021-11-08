package com.example.clientapp.service;

import com.example.clientapp.client.UsersClient;
import com.example.clientapp.model.User;
import com.example.clientapp.model.Users;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class UserService {

    private UsersClient usersClient;

    public UserService(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    public Users getUsers() {
        return usersClient.callServerAndGetUsers();
    }

    public User findTheEldest() {
        Users users = usersClient.callServerAndGetUsers();
        return users.getUsers().stream().max(Comparator.comparing(User::getAge)).orElse(null);
    }
}
