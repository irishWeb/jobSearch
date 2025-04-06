package kz.iitu.csse241.lim.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import kz.iitu.csse241.lim.service.VacancyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@EnableCaching
@PropertySource("classpath:application.properties")
public class CacheConfig {

    @PostConstruct
    public void init() {
        System.out.println("CacheConfig — init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CacheConfig — destroy()");
    }




    @Bean(name = "vacancyCacheManager", initMethod = "toString", destroyMethod = "toString")
    @Scope("singleton")
    public CacheManager cacheManager() {
        System.out.println("CacheManager init");
        return new ConcurrentMapCacheManager("vacancies");
    }

    @Bean
    public CommandLineRunner runner(VacancyService vacancyService) {
        return args -> {
           System.out.println("1st call (from DB):");
            List<?> vacancies1 = vacancyService.getAllVacancies(); //БД

            System.out.println("2nd call (from cache):");
            List<?> vacancies2 = vacancyService.getAllVacancies(); //КЭШ
        };
    }
}