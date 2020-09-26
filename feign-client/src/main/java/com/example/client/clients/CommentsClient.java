package com.example.client.clients;

import com.mylibraries.feign.configurations.CustomConfiguration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "commentsClient", url = "${feign.client.config.commentsClient.url}", configuration = CustomConfiguration.class)
public interface CommentsClient {

    @RequestMapping(method = GET, value = "/comments")
    @CircuitBreaker(name = "commentsClient", fallbackMethod = "getCommentsFallback")
    Object getComments();

    default Object getCommentsFallback(final RuntimeException e) {

        return "THIS WAS RETURNED FROM GET COMMENTS FALL BACK";
    }
}
