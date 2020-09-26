package com.example.client;

import com.example.client.clients.SampleClient;
import com.example.client.clients.SampleClientWithConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(clients = {SampleClient.class, SampleClientWithConfiguration.class})
@Configuration
@ComponentScan
public class FeignClientAutoConfiguration {
}
