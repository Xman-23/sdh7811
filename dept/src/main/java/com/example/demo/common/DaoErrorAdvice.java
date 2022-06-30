package com.example.demo.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoErrorAdvice {

	@AfterThrowing(pointcut = "execution(public* com.example.demo.dao..*(..))",
			throwing = "ex")
	//AfterThrowing 의 첫 매개변수는 JoinPoint
	public void afterError(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"수행시 예외 발생" + ex.getMessage());
	}
}
