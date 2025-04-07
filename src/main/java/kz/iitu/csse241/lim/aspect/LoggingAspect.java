package kz.iitu.csse241.lim.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* kz.iitu.csse241.lim.service.VacancyService.*(..))")
    public void vacancyServiceMethods() {}

    @Before("vacancyServiceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("BEFORE: Calling method " + joinPoint.getSignature().getName());
    }

    @After("vacancyServiceMethods()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("AFTER: Completed method " + joinPoint.getSignature().getName());
    }

    @Around("vacancyServiceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        System.out.println("Method " + joinPoint.getSignature().getName() + " executed in " + duration + " ms");
        return result;
    }
}
