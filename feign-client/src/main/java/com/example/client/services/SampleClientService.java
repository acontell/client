package com.example.client.services;

import com.example.client.clients.SampleClient;
import com.example.client.models.Request;
import com.example.client.models.Response;
import com.example.client.models.SampleClientInterface;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

@Service
public class SampleClientService implements SampleClientInterface {

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
    @Override
    public Response searchCustomerBusiness(final Request request) {

        return this.client.searchCustomerBusiness(request);
    }

    private Response searchCustomerBusinessFallback(final Request request, final RuntimeException e) {

        return null;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerCostCenterFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "searchCustomerCostCenterFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Override
    public Response searchCustomerCostCenter(final Request request) {

        return this.client.searchCustomerCostCenter(request);
    }

    private Response searchCustomerCostCenterFallback(final Request request, final RuntimeException e) {

        return null;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "insertCustomerPersonFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "insertCustomerPersonFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Override
    public Response insertCustomerPerson(final Request request) {

        return this.client.insertCustomerPerson(request);
    }

    private Response insertCustomerPersonFallback(final Request request, final RuntimeException e) {

        return null;
    }

    @CircuitBreaker(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "updateFiscalNameFallback")
    @RateLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Bulkhead(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Retry(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION, fallbackMethod = "updateFiscalNameFallback")
    @TimeLimiter(name = SAMPLE_CLIENT_SERVICE_RESILIENCE_CONFIGURATION)
    @Override
    public Response updateFiscalName(final Request request) {

        return this.client.updateFiscalName(request);
    }

    private Response updateFiscalNameFallback(final Request request, final RuntimeException e) {

        return null;
    }
}
