package com.feedjournal.feedjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FeedJournalApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FeedJournalApplication.class, args);
    }

}
