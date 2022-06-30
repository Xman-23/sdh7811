package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day06301Application {

	public static void main(String[] args) {
		SpringApplication.run(Day06301Application.class, args);

//		MyThread t1 = new MyThread();
//		t1.start();

//		MyThread2 thread2 = new MyThread2();
//		
//		(new Thread(thread2)).start();
//		public class MyThread2 implements Runnable {
//
//			@Override 
//			//자바는 클래스에 다중 상속이 안된다.
//			public void run() {
//				for(int i=1; i<=10; i++)
//				{
//					System.out.println("작업수행 : " +i);
//					
//					try {
//						Thread.sleep(100);
//					} catch (Exception e) {
//						System.out.println("예외 발생 " +e.getMessage());
//					}
//				}
//			}
//
//		}
//		new Thread(/*Implement Runnable 한 객체* 이름없는 클래스를 정의 하고객체 생성/)

		// 쓰레드를 가동하는 것이 목적 , 클래스를 생성 하는것은 불필요 하다 생각
//		 new Thread(new Runnable() // 이름없는 클래스를 정의 하고객체 생성 {
//			
//			@Override
//			public void run() {
//				for(int i=0; i<=10; i++)
//				{
//					System.out.println("작업수행 " + i);
//					
//					try {
//						Thread.sleep(100);
//					} catch (Exception e) {
//						System.out.println("예외 발생 :" + e.getMessage());
//					}
//				}
//			}
//		}).start();

		// 람다식
		// 인터페이스 안에 하나의 메서드 만 있어야 람다식 을 쓸 수 있다.
		// 구현 해야하는 추상 메소드가 하나만 선언된 인터페이스를 =>함수형 인터페이스
		// @FunctionalInterface 함수형인터페이스를 명시 하기 위해서

//		new Thread(()->{
//			
//			for(int i=0; i<=10; i++)
//			{
//				System.out.println("작업 수행" +i);
//			}
//			
//			try {
//				Thread.sleep(100);
//			} catch (Exception e) {
//				System.out.println("예외 발생 :" +e.getMessage());
//			}
//		}).start();
		// Moveable 인터페이스를 구현한 객체를 생성후 메서드 활용
//		Car myCar = new Car();
//		myCar.leftMove();
//		myCar.rightMove();
//		
		
		// 인터페이스를 구현한 객체(클래스)를 생성(만들) 하지 않고 직접 바로 기능만 구현 하는 방법
		// 인터페이스 구현한
		
//		Moveable mycar = new Moveable() {
//
//			@Override
//			public void rightMove() {
//				// TODO Auto-generated method stub
//				System.out.println("우호전 합니다.");
//			}
//
//			@Override
//			public void leftMove() {
//				// TODO Auto-generated method stub
//				System.out.println("좌회전 합니다.");
//			}
//		}; // 이름 없는 클래스 정의 하면서 바로 객체 생성
//
//		mycar.rightMove();
//		mycar.leftMove();
		
		//AnimalSound 인터페이스를 구현한 
		//이름 없는 클래스를 정의 하면서 바로 객체 생성
//		AnimalSound dog = new AnimalSound() {
//			
//			@Override
//			public void sound() {
//				System.out.println("멍멍");
//				
//			}
//		};
//		dog.sound();
		
		//() => new AniamlSound() 를 대체
		//-> 함수를 의미
		
		AnimalSound dog = () -> {
			System.out.println("멍멍");
		};
			dog.sound();
	}

}
