package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.GoodsVO;

public class CustomerManager {
	
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
	
	public static List<CustomerVO> findAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<CustomerVO> list= session.selectList("com.sist.customer.findAll");
		session.close();
		return list;
	}
	
	
	public static CustomerVO findByCustid(int custid) {
		SqlSession session = sqlSessionFactory.openSession();
		CustomerVO c = (CustomerVO)session.selectOne("com.sist.customer.findByCustid",custid);
		session.close();
		return c;
	}
	
	public static int insert(CustomerVO c) {
		int re =  -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("com.sist.customer.insert", c);
		session.commit();
		return re;
	}
	public static int update(CustomerVO c) {
		int re =  -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.update("com.sist.customer.update", c);
		session.commit();
		return re;
	}
	public static int delete(int custid) {
		int re =  -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.delete("com.sist.customer.delete", custid);
		session.commit();
		return re;
	}
	
}












