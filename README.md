# Proof of Concept: Feign clients + resilience technologies

## Main idea
Provide a standarized way of creating feign clients with circuit-breaker and other resilience patterns.

## Pre-requisites:
* Highly customizable clients
* As simple as possible

## Concept
* Clients can be configured using properties
* Clients can be configured programmatically when properties are not enough
* Resilience can be configured using annotations
* Resilience can also be configured programmatically when annotations are not enough

## Idea
* Spring Cloud Open Feign provides client properties configuration and sensible defaults out of the box
* If that's not enough, a library can be provided with configurations, custom decoders, encoders... and so on that can be re-used in different clients.
* Resilience4j provides integration with Spring Boot and can be configured through annotations (even directly over Feign clients interfaces)
* If a more custom configuration is needed, <pre><code>Resilience4jFeign.builder</code></pre> extends <pre><code>Feign.builder</code></pre> and can be used for further configuration. This custom configurations can also be included in the library to improve usability.

## Drawbacks
* We couple our Feign clients to Resilience4j. The alternative could be Spring Cloud Circuit-breaker: an abstraction across different circuit breaker implementations. However, this library is still young and only provides circuit-breaker pattern support whereas Resilience4j provides BulkHead, RateLimiter and other interesting pattern implementations.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Spring Cloud Open Feign documentation](https://cloud.spring.io/spring-cloud-openfeign/reference/html/index.html)
* [Official Resilience4j Reference Guide](https://resilience4j.readme.io/docs/getting-started)
* [Official Spring Cloud Circuit-breaker](https://spring.io/projects/spring-cloud-circuitbreaker)