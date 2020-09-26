package com.example.client;

import com.example.client.clients.SampleClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(clients = SampleClient.class)
@Configuration
@ComponentScan
public class FeignClientAutoConfiguration {
}
