package com.company.yatsenko.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class LogAspect {
    @Before("execution(* com.company.yatsenko.services.*.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Invokation of method s" + joinPoint.getSignature() + joinPoint.getSourceLocation());
    }
    @Around("execution(* com.company.yatsenko.services.*.*(..))")
    public Object aroundServiceMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution of service methods is -> " + joinPoint.getSignature() + " took " + (end - start) + "msec.");
        return res;
    }
}
