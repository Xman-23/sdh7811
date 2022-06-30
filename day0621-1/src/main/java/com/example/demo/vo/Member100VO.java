package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //기본생성자만 제공 
@AllArgsConstructor//모든 멤버를 매개변수 를 갖는 생성자를 만들어줌
@NoArgsConstructor// 기본생성자를 만들어줌
public class Member100VO {
	private String id;
	private String pwd;
	private String name;
	private String role;
}
