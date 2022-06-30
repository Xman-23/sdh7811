package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.EmpVO;

public class EmpManager {
	public static SqlSessionFactory sqlSessionFactory;
	
	static
	{
		try {
			String resource = "com/example/demo/db/sqlMapconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			 sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
			
			 System.out.println("환경 설정 OK");
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
	}

	public static List<EmpVO> findAll()
	{
		System.out.println("매니저 동작함");
		List<EmpVO> e = null;
		SqlSession session = sqlSessionFactory.openSession();
		e = session.selectList("emp.findAll");
		session.close();
		System.out.println(e);
		return e;
	}
	
}
