package com.example.demo;

public class Car implements Moveable {

	//MoveAble에 존재하는 2개의 추상 메서드를 오버라이딩 
	@Override
	public void leftMove() {
		// TODO Auto-generated method stub
		System.out.println("좌 회전 합니다.");
	}

	@Override
	public void rightMove() {
		// TODO Auto-generated method stub
		System.out.println("우 회전 합니다.");
	}

}
