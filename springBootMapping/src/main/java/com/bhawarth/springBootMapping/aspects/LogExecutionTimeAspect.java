package com.bhawarth.springBootMapping.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(com.bhawarth.springBootMapping.annotations.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(proceedingJoinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }
}
