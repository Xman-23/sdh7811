package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	
	@GetMapping("/hello")
	public void Hello(Model model) //model 상태 유지
	{
		model.addAttribute("name", "홍길동"); //전달받을 변수 , 값
		model.addAttribute("age", "20"); // 전달받을 변수 , 값
		
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과"); //list 에 추가
		list.add("포도"); 
		list.add("수박");
	
		model.addAttribute("list", list);
		
 	}
}
