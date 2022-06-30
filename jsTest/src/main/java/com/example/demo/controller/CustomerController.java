package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;


import lombok.Setter;

@RestController
@Setter
public class CustomerController {
	@Autowired
	private CustomerDAO dao;
	
	@RequestMapping("/delete")
	public String delete(int custid) {
		dao.delete(custid);
		return "OK";
	}
	
	
	@RequestMapping("/update")
	public String update(CustomerVO c) {
		dao.update(c);
		return "OK";
	}
	
	
	@RequestMapping("/insert")
	public String insert(CustomerVO c) {
		dao.insert(c);
		return "OK";
	}
	
	
	@RequestMapping("/getCustomer")	
	public CustomerVO getCustomer(int custid) {
		return dao.findByCustid(custid);
	}
	
	
	@RequestMapping("/list")
	public List<CustomerVO> list(){
		return dao.findAll();
	}
	
	
	

	@RequestMapping("/listCustomer")	
	public String listCustomer() {
		String r = "";
		List<CustomerVO> list = dao.findAll();
		r += "<customer_list>";
		for(CustomerVO c :list) {
			r += "<customer>";
			r += "<custid>"+ c.getCustid()+"</custid>";
			r += "<name>"+c.getName()+"</name>";
			r += "<address>"+c.getAddress()+"</address>";
			r += "<phone>"+c.getPhone()+"</phone>";
			r += "</customer>";
		}
		r += "</customer_list>";
		return r;
	}
}








