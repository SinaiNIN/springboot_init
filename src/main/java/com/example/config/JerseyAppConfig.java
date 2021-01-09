package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyAppConfig extends ResourceConfig {
    public JerseyAppConfig(){
        packages("com.example.item.api");
    }
}
