package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

import lombok.Setter;

@RestController
@Setter
public class EmpController {
	
	@Autowired
	private MailSender javaMailSender;
	@Autowired
	private EmpDAO e_Dao;
	
	
}
 