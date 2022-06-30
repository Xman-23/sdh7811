package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.ChatVO;
import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.GoodsVO;

public class ChatManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static List<ChatVO> findAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<ChatVO> list= session.selectList("com.sist.chat.findAll");
		session.close();
		return list;
	}
	
	public static int insert(ChatVO c) {
		int re =  -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("com.sist.chat.insert", c);
		session.commit();
		return re;
	}
	
	
}












