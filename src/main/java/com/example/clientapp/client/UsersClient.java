package com.example.clientapp.client;

import com.example.clientapp.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersClient {

    private RestTemplate restTemplate;
    private String usersUrl;

    public UsersClient(RestTemplate restTemplate, @Value("${users.url}") String usersUrl) {
        this.restTemplate = restTemplate;
        this.usersUrl = usersUrl;
    }

    public Users callServerAndGetUsers() {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer token");
//
//        HttpEntity<User> request = new HttpEntity<>(User.builder().age(20).build(), httpHeaders);
       ResponseEntity<Users> response = restTemplate
                .exchange(usersUrl, HttpMethod.GET, null, Users.class);
        return response.getBody();
    }
}
