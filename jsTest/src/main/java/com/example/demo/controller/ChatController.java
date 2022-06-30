package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ChatDAO;
import com.example.demo.vo.ChatVO;

import lombok.Setter;

@RestController
@Setter
public class ChatController {	
	@Autowired
	private ChatDAO dao;	

	@PostMapping("/insertChat")
	public String insert(ChatVO c) {
		dao.insert(c);
		return "OK";
	}
	
	@GetMapping("/listChat")
	public List<ChatVO> list(){
		return dao.findAll();
	}
}












