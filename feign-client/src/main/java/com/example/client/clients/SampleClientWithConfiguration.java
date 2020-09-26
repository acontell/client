package com.example.client.clients;

import com.example.client.models.Request;
import com.example.client.models.Response;
import com.mylibraries.feign.configurations.CustomConfiguration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "sampleConfiguration", url = "${feign.client.config.sampleConfiguration.url}", configuration = CustomConfiguration.class)
public interface SampleClientWithConfiguration {

    @RequestMapping(method = POST, value = "/search-business")
    @CircuitBreaker(name = "sampleConfiguration", fallbackMethod = "searchCustomerBusinessFallback")
    Response searchCustomerBusiness(@RequestBody final Request request);

    default Response searchCustomerBusinessFallback(final Request request, final RuntimeException e) {

        return null;
    }
}
