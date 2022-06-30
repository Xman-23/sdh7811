package com.example.demo.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class BoardVO {
	
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String content;
	private Date regdate;
	private int hit;
	private String fname;
	private int b_ref; 
	private int b_step; 
	private int b_level; 
	private MultipartFile uploadFile;
	//insert.jsp 에  파일 이름 과 똑같아야한다 (uploadFile = uploadFile)
}	
