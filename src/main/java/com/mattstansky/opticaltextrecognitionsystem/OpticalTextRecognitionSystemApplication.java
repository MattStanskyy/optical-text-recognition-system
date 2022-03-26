package com.mattstansky.opticaltextrecognitionsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mattstansky"})
public class OpticalTextRecognitionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpticalTextRecognitionSystemApplication.class, args);
    }

}
