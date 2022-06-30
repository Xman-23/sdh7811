package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.Member100VO;


@SpringBootApplication
public class Day06211Application {

	@Bean//객체 제공하는 Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Day06211Application.class, args);
	
		/*
		 * String pwd = "tiger"; String pwd2 =
		 * PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(pwd);
		 * System.out.println(pwd2);
		 */
		
//		MemberManager.insert(new MemberVO("tiger",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger") , "홍길동", "user"));
//		MemberManager.insert(new MemberVO("lion", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("lion"), "이순신", "admin"));
//		MemberManager.insert(new Member100VO("sdh",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("sdh"),"서동혁","admin"));
//		MemberManager.insert(new Member100VO("dh",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("dh"),"동혁","user"));
	}

}
