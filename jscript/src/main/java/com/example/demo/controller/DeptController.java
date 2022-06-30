package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
//@Setter
public class DeptController {
	
	@Autowired
	private DeptDAO d_Dao;

	public void setD_Dao(DeptDAO d_Dao) {
		this.d_Dao = d_Dao;
	}
	
	
	@RequestMapping("/listDept")
	@ResponseBody
	public List<DeptVO> findAll()
	{	System.out.println("컨트롤러 동작함");
		return d_Dao.findAll();
	}
	
	
}
