package com.coolieexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoolieExpressApplication {

    public static void main(String[] args) {
        System.out.println("Starting Coolie Express Application...");
        SpringApplication.run(CoolieExpressApplication.class, args);
    }
}
