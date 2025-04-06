package kz.iitu.csse241.lim.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.*;

@Configuration
@Profile("dev")
public class DevConfig {

    @PostConstruct
    public void postConstruct() {
        System.out.println("DEV profile");
    }

    @Bean
    public String devMessage() {
        return "Application running in DEV mode";
    }
}