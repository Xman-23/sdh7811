package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.youiwe.webservice.BitSms;

@SpringBootApplication
public class JsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsTestApplication.class, args);
		
		BitSms.sendMsg("01025598279", "01093917811", "readygetsetgo");
		System.out.println("OK");
	}

}
