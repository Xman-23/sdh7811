package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

@RestController // @ResponseBody + @Controller
public class CustomerController {
	
	@Autowired
	private CustomerDAO dao;

	public CustomerDAO getDao() {
		return dao;
	}
	
	@RequestMapping("/listCustomer")
	@ResponseBody
	public List<CustomerVO> listCustomer()
	{
		return dao.findAll();
	}
}
