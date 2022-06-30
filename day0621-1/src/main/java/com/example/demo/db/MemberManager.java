package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.Member100VO;


public class MemberManager {
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

		public static int insert(Member100VO m)
		{
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession();
			re = session.insert("member.insert",m);
			session.commit();
			session.close();
			return re;
		}
		public static Member100VO findByID(String id)
		{
			Member100VO v = null;
			SqlSession session = sqlSessionFactory.openSession();
			v = session.selectOne("member.findById",id);
			System.out.println(v);
			session.close();
			return v;
		}
	
}
