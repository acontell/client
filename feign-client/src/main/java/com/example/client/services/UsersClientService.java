package com.example.client.services;

import com.example.client.clients.UsersClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

@Service
public class UsersClientService {

    private static final String USERS_CLIENT_RESILIENCE_CONFIGURATION = "usersClient";

    private final UsersClient client;

    UsersClientService(final UsersClient client) {

        this.client = client;
    }

    @CircuitBreaker(name = USERS_CLIENT_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerBusinessFallback")
    @RateLimiter(name = USERS_CLIENT_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = USERS_CLIENT_RESILIENCE_CONFIGURATION)
    @Retry(name = USERS_CLIENT_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerBusinessFallback")
    @TimeLimiter(name = USERS_CLIENT_RESILIENCE_CONFIGURATION)
    public String getUsers(final String request) {

        // Do some logic

        return this.client.getUsers().toString();
    }

    private String getUsers(final String request, final RuntimeException e) {

        return null;
    }
}
