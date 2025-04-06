package kz.iitu.csse241.lim.config;



import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.*;

@Configuration
@Profile("prod")
public class ProdConfig {

    @PostConstruct
    public void postConstruct() {
        System.out.println("PROD profile active");
    }

    @Bean
    public String prodMessage() {
        return "Application running in PROD mode";
    }
}