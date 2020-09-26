package com.example.sample.app.controllers;

import com.example.client.clients.CommentsClient;
import com.example.client.services.UsersClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final UsersClientService usersClientService;
    private final CommentsClient client;

    TestController(final UsersClientService usersClientService,
                   final CommentsClient client) {

        this.usersClientService = usersClientService;
        this.client = client;
    }

    @GetMapping("/test-client")
    public String getResponse() {

        return this.usersClientService.getUsers("HELLO");
    }

    @GetMapping("/test-client-with-configuration")
    public Object getResponseWithConfiguration() {

        return this.client.getComments();
    }
}
