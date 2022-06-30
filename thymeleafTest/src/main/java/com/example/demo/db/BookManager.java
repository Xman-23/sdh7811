package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVO;

public class BookManager {

	static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			String resource = "com/example/demo/db/sqlMapconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 발생 : " + e.getMessage());
		}
	}

	public static List<BookVO> b_List() {
		List<BookVO> b_list = null;
		SqlSession session = sqlSessionFactory.openSession();
		b_list = session.selectList("book.findAll");
		session.close();

		return b_list;
	}

	public static BookVO findbyno(int bookid) {
		BookVO b = null;
		SqlSession session = sqlSessionFactory.openSession();
		b = session.selectOne("book.findByNo", bookid);
		session.close();

		return b;

	}

	public static int update(BookVO b) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.update("book.update", b);
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
	
	public static int insert(BookVO b)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("book.insert",b);
		session.commit();
		session.close();
		
		return re;
	}

}
