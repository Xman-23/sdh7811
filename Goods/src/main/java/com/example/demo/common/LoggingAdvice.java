package com.example.demo.common;

import java.io.FileWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.SistLogDAO;
import com.example.demo.vo.SistLog;

import lombok.Setter;

@Component//자동 스캔
@Aspect //AOP 를 사용할겁니다.
@Setter
public class LoggingAdvice {

	@Autowired
	private SistLogDAO dao;
	
	@Pointcut("execution(public* com.example.demo.controller..*(..))")
	// 이 패키지의 하위(..) *(모든클래스) () 메서드 를 .. 매개변수 있거나 없거나 상관없이 가져옴
	public void controller()
	{
		
	}
	
	@Around("controller()")
	public Object logging(ProceedingJoinPoint joinPoint) {
		Object re =  null;
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		System.out.println(request);
		String url = request.getRequestURL().toString();
		String addr = request.getRemoteAddr();
		System.out.println("url:"+url);
		System.out.println("addr:"+addr);
		Date today = new Date();
		int year = today.getYear() + 1900;
		int month = today.getMonth()+1;
		int date = today.getDate();
		int hh = today.getHours();
		int mm = today.getMinutes();
		int ss = today.getSeconds();
		String time = year + "년 "+ month + "월 "+ date + "일 "+ hh+":"+mm+":"+ss;
		long start = System.currentTimeMillis();
		try {
			re = joinPoint.proceed();//타깃 메소드를 호출
		}catch (Throwable e) {
			// TODO: handle exception
		}
		
		long end = System.currentTimeMillis();
		long delay = end - start;
		
		SistLog log = new SistLog(ss, url, addr, time, delay);
		dao.insert(log);
		System.out.println(log);
		return re;
	}
//	@Around("controller()")
//	public Object logging(ProceedingJoinPoint joinPoint) {
//		
//		Object re = null;
//		
//		
//		 HttpServletRequest request= (HttpServletRequest) joinPoint.getArgs()[0];
//		 String url = request.getRequestURI();
//		 String addr = request.getRemoteAddr();
//		 System.out.println("url:"+url);
//		 System.out.println("addr:"+addr);
//		//Args ( 배열 을 반환 ) 
//		//getARgs() 타깃 메소드의 매개 변수들을 배열로 알려줍니다.
//		 
//		Date today = new Date();
//		int year = today.getYear() +1900;
//		int month = today.getMonth()+1;
//		int date = today.getDate();
//		int day = today.getDay();
//		int hours = today.getHours();
//		int minutes = today.getMinutes();
//		int seconds = today.getSeconds();
//		String time = year+"년"+month+"월"+ date+"일"+day+"일"+hours+"시"+minutes+"분"+seconds+"초";
//		long start = System.currentTimeMillis();
//		
//		
//		try {
//			re = joinPoint.proceed(); //타깃 메소드 를 호출
//		} catch (Throwable e) {
//			// TODO: handle exception
//		}
//		
//		long end = System.currentTimeMillis();
//		long delay = end-start;
//				
//		try {
//			FileWriter fr = new FileWriter("c:/sist/log.dat",true);
//			String row = "url:" +url + "/addr:" + addr +  "/"+addr+"/"+time+"/"+delay+"\n\r";
//			fr.write(row);
//			fr.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("에외 발생 :" + e.getMessage());
//		}
//		
//		return re;
//		
//	}
	}

