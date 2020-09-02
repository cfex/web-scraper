package com.web.scrapper;

import com.web.scrapper.web.ScrapperService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class ScrapperApplication {
    private static Environment env;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ScrapperApplication.class, args);
    }

}
