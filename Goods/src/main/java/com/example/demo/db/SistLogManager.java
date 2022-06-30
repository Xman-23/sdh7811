package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.SistLog;

import org.apache.ibatis.io.Resources;

public class SistLogManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외 발생:" + e.getMessage());
		}
	
	}
	public static int insert(SistLog s)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("sistLog.insert",s);
		session.commit();
		session.close();
		
		return re;
				
	}

}
