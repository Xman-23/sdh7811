package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.ChatManager;
import com.example.demo.vo.ChatVO;

@Repository
public class ChatDAO {
	
	public int insert(ChatVO c) {
		return ChatManager.insert(c);
	}
	
	public List<ChatVO> findAll(){
		return ChatManager.findAll();
	}
}







