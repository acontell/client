package com.example.sample.app.controllers;

import com.example.client.services.SampleClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final SampleClientService sampleClientService;

    TestController(final SampleClientService sampleClientService) {

        this.sampleClientService = sampleClientService;
    }

    @GetMapping("/test-client")
    public String getResponse() {

        return this.sampleClientService.searchCustomerCostCenter("HELLO");
    }
}
