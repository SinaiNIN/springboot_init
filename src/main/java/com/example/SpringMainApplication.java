package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMainApplication {

    public static void main(String[] args) throws Exception {
        ApplicationDatabaseInitializer.verify();
        SpringApplication.run(SpringMainApplication.class, args);
    }

}
