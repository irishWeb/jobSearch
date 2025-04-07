package kz.iitu.csse241.lim.aspect;

import kz.iitu.csse241.lim.service.VacancyService;
import kz.iitu.csse241.lim.repository.VacancyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;

import static org.mockito.Mockito.*;

@SpringJUnitConfig(classes = LoggingAspectTest.TestConfig.class)
class LoggingAspectTest {

    @Configuration
    @EnableAspectJAutoProxy
    static class TestConfig {

        @Bean
        public LoggingAspect loggingAspect() {
            return new LoggingAspect();
        }

        @Bean
        public VacancyRepository vacancyRepository() {
            return mock(VacancyRepository.class);
        }

        @Bean
        public VacancyService vacancyService(VacancyRepository vacancyRepository) {
            VacancyService service = new VacancyService(vacancyRepository);
            when(vacancyRepository.findAll()).thenReturn(Collections.emptyList());
            return service;
        }
    }

    @Test
    void testAopTrigger() {

        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        VacancyService service = context.getBean(VacancyService.class);

        service.getAllVacancies();
    }
}
