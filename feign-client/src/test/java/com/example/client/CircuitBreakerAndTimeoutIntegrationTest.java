package com.example.client;

import com.example.client.clients.CommentsClient;
import com.example.client.services.UsersClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CircuitBreakerAndTimeoutIntegrationTest {

    @Autowired
    private CommentsClient commentsClient;
    @Autowired
    private UsersClientService service;

    @Test
    void it_should_activate_circuit_breaker_when_timeout_is_thrown_in_users_client() {

        assertThat(this.service.getUsers("HELLO")).isEqualTo("THIS WAS RETURNED FROM GET USERS FALL BACK");
    }

    @Test
    void it_should_activate_circuit_breaker_when_timeout_is_thrown_in_comments_client() {

        assertThat(this.commentsClient.getComments()).isEqualTo("THIS WAS RETURNED FROM GET COMMENTS FALL BACK");
    }
}