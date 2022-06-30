package com.example.demo.utill;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling //xml 이 아닌 어노케이션 방식
public class SistUtill {

	/*
	 * @Scheduled(fixedRate = 10000) //시간 마다 반복 
	 * public void test() {
	 * System.out.println("콜콜!!"); }
	 */
	@Scheduled(cron = "10 27 9 21 * ?")
	public void test2()
	{
		System.out.println("메일발송");
	}
}
