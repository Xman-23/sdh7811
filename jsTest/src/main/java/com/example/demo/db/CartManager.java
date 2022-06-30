package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CartVO;
import com.example.demo.vo.GoodsVO;

public class CartManager {
	
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
	
		public static int insert(CartVO[] c)
		{
			int re =-1;
			SqlSession session = sqlSessionFactory.openSession();
			re = session.insert("cart.insert", c);
			session.commit();
			session.close();
			return re;
		}
		
		public static int no()
		{
			int n = 0;
			SqlSession session = sqlSessionFactory.openSession();
			n = session.selectOne("cart.nextno");
			session.close();
			return n;
		}
	
}












