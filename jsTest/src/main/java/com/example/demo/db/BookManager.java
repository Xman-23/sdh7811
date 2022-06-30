package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVO;
import com.example.demo.vo.CartVO;
import com.example.demo.vo.GoodsVO;

public class BookManager {
	
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
	
	public static List<BookVO> listBook(){
		List<BookVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("book.findAll");
		session.close();
		return list;
	}
	
	public static int insert(BookVO b)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("book.insert",b);
		session.commit();
		session.close();
		
		return re;
	}
	
	public static int update(BookVO b)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.update("book.update",b);
		session.commit();
		session.close();
		
		return re;
	}
	
	public static int delete(int bookid)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.delete("book.delete",bookid);
		session.commit();
		session.close();
		
		return re;
	}
	
}












