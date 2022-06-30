package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ScheduleDAO;
import com.example.demo.vo.ScheduleVO;

import lombok.Setter;

@RestController //어떤 요청에도 동일하게 응답
@Setter
public class ScheduleController {
	
		@Autowired // 자동으로 의존 관계 형성
		private ScheduleDAO s_Dao;
		//Query 형식 get, object 형식 post
		
		@GetMapping("/insertSchedule")
		public String insert(ScheduleVO s)
		{
			s_Dao.insert(s);
			
			return "OK";
		}
		@GetMapping("/listSchedule") 
		public List<ScheduleVO> list()
		{
			return s_Dao.s_findAll();
		}
	
}
