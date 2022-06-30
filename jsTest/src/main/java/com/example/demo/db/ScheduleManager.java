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
import com.example.demo.vo.ScheduleVO;

public class ScheduleManager {
	
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
	
	public static int insert(ScheduleVO s)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("schedule.insert", s);
		session.commit();
		session.close();
		
		return re;
	}
	public static List<ScheduleVO> s_findAll()
	{
		List<ScheduleVO> s_list = null;
		SqlSession session = sqlSessionFactory.openSession();
		s_list = session.selectList("schedule.findAll");
		session.close();
		return s_list;
	}
	
	
}












