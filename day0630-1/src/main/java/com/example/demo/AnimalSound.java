package com.example.demo;

@FunctionalInterface // 함수형 인터페이스 라는것 을 알리는 @FunctionalInterface
public interface AnimalSound {

	//모든 AnimalSound 는 sound (메서드)를 구현해야 해
	public void sound();
}
