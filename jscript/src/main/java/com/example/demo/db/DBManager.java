package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	
	static
	{
		try {
			String resource = "com/example/demo/db/sqlMapconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("μμΈλ°μ : "+ e.getMessage());
		}
	}
	public static List<DeptVO> findAll()
	{
		List<DeptVO> d_list=null;
		SqlSession session = sqlSessionFactory.openSession();
		d_list = session.selectList("dept.findAll");
		session.close();
		
		return d_list;
		
	}
}
