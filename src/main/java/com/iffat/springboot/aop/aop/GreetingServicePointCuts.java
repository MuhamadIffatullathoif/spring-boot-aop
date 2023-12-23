package com.iffat.springboot.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointCuts {

    @Pointcut("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){}

    @Pointcut("execution(String com.iffat.springboot.aop.services.GreetingService.*(..))")
    public void greetingFooPointCut(){}
}
