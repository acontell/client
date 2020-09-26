package com.example.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;

@SpringBootApplication
@RestController
public class CustomApplication {

    private static final int MORE_THAN_COMMENTS_TIMEOUT = 400;
    private static final int MORE_THAN_USERS_TIMEOUT = 650;

    @GetMapping("/comments")
    public Object getCommentsSlow() throws InterruptedException {

        sleep(MORE_THAN_COMMENTS_TIMEOUT);

        return null;
    }

    @GetMapping("/users")
    public Object getUsersSlow() throws InterruptedException {

        sleep(MORE_THAN_USERS_TIMEOUT);

        return null;
    }
}
