package com.bhawarth.springBootMapping.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.bhawarth.springBootMapping.services.EmployeeService.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
//        logger.info("Before method execution {}", joinPoint);
        logger.warn("Before method execution {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.bhawarth.springBootMapping.services.EmployeeService.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
//        logger.info("After method execution {}", joinPoint);
        logger.warn("After method execution {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.bhawarth.springBootMapping.services.EmployeeService.*(..))", returning = "result")
    public void logAfterReturningMethod(Object result) {
//        logger.info("After method execution {}", joinPoint);
        logger.info("Method returned successfully with result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.bhawarth.springBootMapping.services.EmployeeService.*(..))", throwing = "ex")
    public void logAfterThrowingMethod(Exception ex) {
//        logger.info("After method execution {}", joinPoint);
        logger.error("Method threw exception: " + ex.getMessage());
    }

    @Around("execution(* com.bhawarth.springBootMapping.services.EmployeeService.*(..))")
    public Object logThrowingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info("After method execution {}", joinPoint);
        long startTime = System.currentTimeMillis();
        logger.error("Before returning method execution in around advise {}", joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Time taken: {}", endTime - startTime);
        logger.error("After returning method execution in around advise {}", joinPoint.getSignature().getName());
        return result;
    }








}
