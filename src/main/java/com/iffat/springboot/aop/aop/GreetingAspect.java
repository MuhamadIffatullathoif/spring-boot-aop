package com.iffat.springboot.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("before: Method: {}, args: {}", method, args);
    }

    @After("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: Method: {}, args: {}", method, args);
    }

    @AfterReturning("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterReturning : Method: {}, args: {}", method, args);
    }

    @AfterThrowing("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterThrowing: Method: {}, args: {}", method, args);
    }

    @Around("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("around: Method: {}, args: {}", method, args);
            result = joinPoint.proceed();
            logger.info("around: Method: {}, result: {}", method, result);
            return result;
        } catch (Throwable e) {
            logger.info("around throwable: Method: {}", method);
            throw e;
        }
    }
}
