package com.example.demo.advice;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //Aop 설정
@Component // 자동으로 스캔되기 위해 Component
public class LogginAdvice {
	
	
	//어드바이스가 동작할 타켓을 설정합니다.
	//com.example.demo.controller (하위의).. (모든 클래스들)* 의 모든 메소드(..)들을 타켓으로 설정 
	@Pointcut ("execution(public* com.example.demo.controller..*(..))")// 어떠한 메소드 를 타깃으로 삼아 실행한것이냐
	public void test() // <--- 그 타켓을 대표하는 id 입니다.
	{
		//구현부(body)를 써봤자 의미 없으며
		//반환형은 반드시 void 
	}
	
	@After("test()") //포인트 컷 이름 을 설정 ( 타켓으로 )  
	//test()(메서드 이름()) 갖는 pointcut에 설정된 메소들이 동작한 후에 다음의 메소드가 작동 된다 
	//(모든 패키지의 메서드가 실행 된 후(After) 공통으로 실행)

	public void  afterError (JoinPoint joinPoint)
	{
		
		String methodname = joinPoint.getSignature().toLongString();
		
		System.out.println(methodname + "타깃메소드가 정상적으로 완료");
	}
	
//	@AfterReturning("test()")
//	public void  afterError (JoinPoint joinPoint)
//	{
//		
//		String methodname = joinPoint.getSignature().toLongString();
//		
//		System.out.println(methodname + "타깃메소드가 정상적으로 완료");
//	}
	
	
	
//	@AfterReturning("test()")
//	public void  afterOK ()
//	{
//		System.out.println("타깃메소드가 정상적으로 완료");
//	}
	
	
//	@Before("test()") // Before advice 수행 (매개변수가 필요없음)
//	public void befor(JoinPoint joinpoint)
//	{
//		String methodName = joinpoint.getSignature().toShortString();
//		System.out.println(methodName+"메소드 동작하기 전입니다.");
//	}
	
//	
//	@Around("test()")
//	public Object pro(ProceedingJoinPoint joinPoint)  //반드시 반환형은 Object ProceedingJoinPoint 가져야함
//	{					
//		Object re = null;
//		String methodName = joinPoint.getSignature().toShortString();//메소드
//		long start = System.currentTimeMillis();
//		System.out.println(methodName+"이 동작하기 전입니다.");
//		try {
//			
//			re = joinPoint.proceed();//타깃이 되는 메소드를 동작시킨다
//			
//		} catch (Throwable e) { //Throwable 로 예외 처리
//			// TODO: handle exception
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(methodName+"이 동작한 후입니다.");
//		System.out.println("걸린시간:" + (end-start));
//		//advice 를 만드는것
//	
//		return re;
//	}
}
