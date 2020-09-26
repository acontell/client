package com.example.client.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "usersClient", url = "${feign.client.config.usersClient.url}")
public interface UsersClient {

    @RequestMapping(method = GET, value = "/users")
    Object getUsers();
}
