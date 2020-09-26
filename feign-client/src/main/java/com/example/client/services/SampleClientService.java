package com.example.client.services;

import com.example.client.clients.SampleClient;
import com.example.client.models.Request;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

@Service
public class SampleClientService {

    private static final String SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION = "sampleService";

    private final SampleClient client;

    SampleClientService(final SampleClient client) {

        this.client = client;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerBusinessFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerBusinessFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    public String searchCustomerBusiness(final String request) {

        // Do some logic

        return this.client.searchCustomerBusiness(new Request()).toString();
    }

    private String searchCustomerBusinessFallback(final String request, final RuntimeException e) {

        return null;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerCostCenterFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerCostCenterFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    public String searchCustomerCostCenter(final String request) {

        // Do some logic

        return this.client.searchCustomerCostCenter(new Request()).toString();
    }

    private String searchCustomerCostCenterFallback(final String request, final RuntimeException e) {

        return null;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "insertCustomerPersonFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "insertCustomerPersonFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    public String insertCustomerPerson(final String request) {

        // Do some logic

        return this.client.insertCustomerPerson(new Request()).toString();
    }

    private String insertCustomerPersonFallback(final String request, final RuntimeException e) {

        return null;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "updateFiscalNameFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "updateFiscalNameFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    public String updateFiscalName(final String request) {

        // Do some logic

        return this.client.updateFiscalName(new Request()).toString();
    }

    private String updateFiscalNameFallback(final String request, final RuntimeException e) {

        return null;
    }
}
