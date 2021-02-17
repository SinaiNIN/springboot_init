package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/init")
public class JerseyAppConfig extends ResourceConfig {
    public JerseyAppConfig(){
        packages("com.example");
    }
}
