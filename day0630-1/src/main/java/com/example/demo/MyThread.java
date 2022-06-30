package com.example.demo;

public class MyThread extends Thread {
	
	//아버지
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			System.out.println("작업 수행 : " + i);
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("예외 발생 : " + e.getMessage());
			}
		}
	}

	
}
