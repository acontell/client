package com.example.client;

import com.example.client.clients.CommentsClient;
import com.example.client.clients.UsersClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(clients = {UsersClient.class, CommentsClient.class})
@Configuration
@ComponentScan
public class FeignClientAutoConfiguration {
}
