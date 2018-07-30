package com.capgemini.alewandowski.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration

@Component
@Aspect
public class TimeLoggerAspect {
	
	@Pointcut("execution( * com.capgemini.alewandowski.*.*(..))")
    public void methods() {
    }

    @Around("methods()")
    public void profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        
      
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
      
    }

}