package com.iffat.springboot.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Before FOO: method - {} - args - {}", method, args);
    }
    @After("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After FOO: Method: {}, args: {}", method, args);
    }

}