package com.example.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class MemberDAO {

	public void insert() {
		System.out.println("OK");
	}
}
