package com.example.sample.app.controllers;

import com.example.client.clients.SampleClientWithConfiguration;
import com.example.client.models.Request;
import com.example.client.models.Response;
import com.example.client.services.SampleClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final SampleClientService sampleClientService;
    private final SampleClientWithConfiguration client;

    TestController(final SampleClientService sampleClientService,
                   final SampleClientWithConfiguration client) {

        this.sampleClientService = sampleClientService;
        this.client = client;
    }

    @GetMapping("/test-client")
    public String getResponse() {

        return this.sampleClientService.searchCustomerCostCenter("HELLO");
    }

    @GetMapping("/test-client-with-configuration")
    public Response getResponseWithConfiguration() {

        return this.client.searchCustomerBusiness(new Request());
    }
}
