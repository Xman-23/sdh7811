package com.example.demo;
////추상 메서드 를 하나라도 가지고 있다면 인터페이스를 구현해야한다.
public class MyThread2 implements Runnable {

	@Override 
	//자바는 클래스에 다중 상속이 안된다.
	public void run() {
		for(int i=1; i<=10; i++)
		{
			System.out.println("작업수행 : " +i);
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("예외 발생 " +e.getMessage());
			}
		}
	}

}
