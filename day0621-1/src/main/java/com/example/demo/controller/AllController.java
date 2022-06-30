package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllController {
	
	@RequestMapping("/all/test1")
	public String test1()
	{
		return "test1";
	}
	
	@RequestMapping("/all/test2")
	public String test2()
	{
		return "test2";
	}
	
	@RequestMapping("/admin/menu1")
	public String menu1() {
		return "admin1";
	}
	
	@RequestMapping("/admin/menu2")
	public String menu()
	{
		return "admin2";
	}
	
	
	
	@RequestMapping("/service2")
	public String service2()
	{
		return "service2";
	}
}
